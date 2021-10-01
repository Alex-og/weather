package ua.haleta.weather.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.haleta.weather.services.AbstractWeatherService;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@RestController
@RequestMapping("/")
public class WebController {

    private final AbstractWeatherService service;

    public WebController(AbstractWeatherService service) {
        this.service = service;
    }

    @GetMapping("/five-days/{city}")
    public ResponseEntity<?> fiveDays(@PathVariable("city") String city) {
        return new ResponseEntity<>(service.fiveDays(city), HttpStatus.OK);
    }

    @GetMapping("/today/{city}")
    public ResponseEntity<?> today(@PathVariable("city") String city) {
        return new ResponseEntity<>(service.today(city), HttpStatus.OK);
    }
}
