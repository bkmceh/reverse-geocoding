package com.example.reversegeocoding.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.reversegeocoding.server.service.GeocodingService;

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
