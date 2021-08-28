package inforest.reversegeocoding.client;

import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;



public class Main {
    private final static String url = "http://localhost:8080/api/address/get?";
    private final static double LAT = 54.741646;
    private final static double LON = 48.734;
    public static void main(String[] args) {
        try(CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(createRequest());
            final int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK != statusCode) {
                throw new ParseException("Unable to get response");
            }
            String address = EntityUtils.toString(response.getEntity());
            System.out.format("LAT: %s, LON: %s\nAddress: %s", LAT, LON, address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HttpUriRequest createRequest() {
        return new HttpGet(url + String.format("lat=%s&lon=%s", LAT, LON));
    }
}
