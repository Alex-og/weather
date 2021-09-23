package ua.haleta.weather.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.haleta.weather.dto.WeatherMapDTO;
import ua.haleta.weather.dto.WeatherMapTimeDTO;
import ua.haleta.weather.model.WeatherWindow;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Service
@Slf4j
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

    public void fortyDays(String city) {
        WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);
        List<WeatherMapTimeDTO> dates = Objects.requireNonNull(weatherMap).getList();
        List<WeatherWindow> resultList = new LinkedList<>();

        dates.forEach(x -> resultList.add(getWeather(city, x)));
        resultList.forEach(x -> log.info("\n" + x.toString()));
    }

    public void today(String city) {
        WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);
        log.info("\n" + getWeather(city, weatherMap.getList().get(0)).toString());
    }

    private WeatherWindow getWeather(String city, WeatherMapTimeDTO dt) {
        WeatherWindow window = new WeatherWindow();
        window.setCity(city);
        window.setDt(dt.getDt());
        window.setTemp(dt.getMain().getTemp());
        window.setTemp_min(dt.getMain().getTemp_min());
        window.setTemp_max(dt.getMain().getTemp_max());
        window.setPressure(dt.getMain().getPressure());
        window.setHumidity(dt.getMain().getHumidity());
        return window;
    }

    private String url(String city) {
        return String.format("%sq=%s&appid=%s", URI, city, API_ID);
    }
}
