package inforest.reversegeocoding.server.service;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Service;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import inforest.reversegeocoding.server.repository.IGeocodingRepository;
import inforest.reversegeocoding.server.model.entity.AddressMapperEntity;
import inforest.reversegeocoding.server.model.dto.SuggestionsListResponse;
import inforest.reversegeocoding.server.exception.AddressNotFoundException;


@Service
public class GeocodingService {

    private final static ObjectMapper MAPPER = new ObjectMapper();
    private final static String url = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/geolocate/address?";

    @Autowired
    private IGeocodingRepository geocodingRepository;

    public String getAddress(final double lat, final double lon) {
        for (AddressMapperEntity addressMapperEntity : geocodingRepository.findAll()) {
            if (addressMapperEntity.getLat() == lat && addressMapperEntity.getLon() == lon) {
                return "Found from Database: " + addressMapperEntity.getAddress();
            }
        }

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(createRequest(lat, lon));
            final int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK != statusCode) {
                throw new ParseException("Unable to get response");
            }
            String jsonResponse = EntityUtils.toString(response.getEntity());
            SuggestionsListResponse suggestionsListResponse;
            suggestionsListResponse = MAPPER.readValue(jsonResponse, SuggestionsListResponse.class);
            if (suggestionsListResponse.getSuggestions().isEmpty()) {
                throw new AddressNotFoundException("Can not find address, try again");
            }
            String address = suggestionsListResponse.getSuggestions().get(0).getValue();
            geocodingRepository.save(new AddressMapperEntity(lat, lon, address));
            return "Not found from Database, saved: " + address;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpUriRequest createRequest(final double lat, final double lon) {
        final HttpGet request = new HttpGet(url + String.format("lat=%s&lon=%s&count=1", lat, lon));
        request.setHeader("Authorization", "Token 25f7041b93d446d31e44f13dcb17b1a86017eea4");
        return request;
    }
}
