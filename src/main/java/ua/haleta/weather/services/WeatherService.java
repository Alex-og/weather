package ua.haleta.weather.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.haleta.weather.dto.WeatherMapDTO;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Service
public class WeatherService {

    private final String URI = "http://api.openweathermap.org/data/2.5/forecast?units=metric&";
    private final String API_ID = "2165181b533b1e072f2c691a3be8971d";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<?> weatherForecastAverage(String city) {
        var resourceUrl = url(city);
        return restTemplate.getForEntity(resourceUrl, String.class);
    }

    public ResponseEntity<?> ddd(String city) {
        WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);
        System.out.println(weatherMap.toString());
        return restTemplate.getForEntity(url(city), String.class);
    }

    private String url(String city) {
        return String.format("%sq=%s&appid=%s", URI, city, API_ID);
    }
}
