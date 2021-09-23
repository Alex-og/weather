package ua.haleta.weather.services;

/**
 * @author Oleksandr Haleta
 * 2021
 */
public interface AbstractWeatherService {

    void fortyDays(String city);
    void today(String city);
}
