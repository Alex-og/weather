package ua.haleta.weather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.haleta.weather.services.WeatherService;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>/*Mono<CurrentWeatherDto>*/ weatherForecast(@RequestParam(required = true) String city) {
        //return service.weatherForecast(city);
        return new ResponseEntity<>(service.weatherForecast(city), HttpStatus.OK);
    }
}
