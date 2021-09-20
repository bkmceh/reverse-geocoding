package inforest.reversegeocoding.controller;

import inforest.reversegeocoding.service.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class GeocodingController {

    @Autowired
    private GeocodingService geocodingService;

    @GetMapping("/get")
    public ResponseEntity<String> getAddress(@RequestParam double lat, @RequestParam double lon) {
        return ResponseEntity.ok(geocodingService.getAddress(lat, lon));
    }
}
