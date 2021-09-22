package ua.haleta.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.haleta.weather.services.WeatherService;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@RestController
@RequestMapping("/")
public class WeatherController {
    private static final Logger log = LoggerFactory.getLogger(WeatherController.class);

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping(value = "weather/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> weatherForecastAverage(@PathVariable(value = "city") String city) {
        //return service.weatherForecastAverage(city);
        return service.ddd(city);
    }
}
