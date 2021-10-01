package ua.haleta.weather.repository;

import ua.haleta.weather.dto.WeatherMapDTO;

/**
 * @author Oleksandr Haleta
 * 2021
 */
public interface AbstractParserWeather {
    void setCity(String city);
    WeatherMapDTO getWeatherMap();
}
