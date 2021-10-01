package ua.haleta.weather.services;

import ua.haleta.weather.model.WeatherFrame;

import java.util.List;

/**
 * @author Oleksandr Haleta
 * 2021
 */
public interface AbstractWeatherService {

    List<?> fiveDays(String city);
    WeatherFrame today(String city);
}
