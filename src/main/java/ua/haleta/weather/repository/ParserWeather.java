package ua.haleta.weather.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.haleta.weather.dto.WeatherMapDTO;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Service
public class ParserWeather implements AbstractParserWeather {

    @Value("${spring.application.URI}")
    private String URI;
    @Value("${spring.application.API_ID}")
    private String API_ID;
    private RestTemplate restTemplate;
    private String city;

    public ParserWeather(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public WeatherMapDTO getWeatherMap() {
        return this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);
    }

    private String url(String city) {
        return String.format("%sq=%s&appid=%s", URI, city, API_ID);
    }
}
