package ua.haleta.weather.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.haleta.weather.dto.WeatherMapDTO;
import ua.haleta.weather.dto.WeatherMapTimeDTO;
import ua.haleta.weather.model.WeatherWindow;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Service
@Slf4j
public class WeatherService implements AbstractWeatherService {

    @Value("${spring.application.URI}")
    private String URI;
    @Value("${spring.application.API_ID}")
    private String API_ID;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public void setAPI_ID(String API_ID) {
        this.API_ID = API_ID;
    }

    @Override
    public void fiveDays(String city) {
        WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);
        List<WeatherMapTimeDTO> dates = Objects.requireNonNull(weatherMap).getList();
        List<WeatherWindow> resultList = new LinkedList<>();

        dates.forEach(x -> resultList.add(getWeather(city, x)));
        resultList.forEach(x -> log.info("\n" + x.toString()));
    }

    @Override
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
