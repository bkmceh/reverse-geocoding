package inforest.reversegeocoding.server.controller;

import inforest.reversegeocoding.server.service.GeocodingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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
