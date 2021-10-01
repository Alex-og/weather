package ua.haleta.weather.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.haleta.weather.dto.WeatherMapDTO;
import ua.haleta.weather.dto.WeatherMapTimeDTO;
import ua.haleta.weather.model.WeatherFrame;
import ua.haleta.weather.repository.AbstractParserWeather;

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

    private final AbstractParserWeather parserWeather;

    public WeatherService(AbstractParserWeather parserWeather) {
        this.parserWeather = parserWeather;
    }

    @Override
    public List<WeatherFrame> fiveDays(String city) {
        WeatherMapDTO weatherMap = getWeatherMap(city);
        List<WeatherMapTimeDTO> dates = Objects.requireNonNull(weatherMap).getList();
        List<WeatherFrame> resultList = new LinkedList<>();

        dates.forEach(x -> resultList.add(getWeather(city, x)));
        resultList.forEach(x -> log.info("\n" + x.toString()));
        return resultList;
    }

    @Override
    public WeatherFrame today(String city) {
        WeatherMapDTO weatherMap = getWeatherMap(city);
        log.info("\n" + getWeather(city, weatherMap.getList().get(0)).toString());
        return getWeather(city, weatherMap.getList().get(0));
    }

    private WeatherMapDTO getWeatherMap(String city) {
        parserWeather.setCity(city);
        return parserWeather.getWeatherMap();
    }

    private WeatherFrame getWeather(String city, WeatherMapTimeDTO dt) {
        WeatherFrame window = new WeatherFrame();
        window.setCity(city);
        window.setDt(dt.getDt());
        window.setTemp(dt.getMain().getTemp());
        window.setTemp_min(dt.getMain().getTemp_min());
        window.setTemp_max(dt.getMain().getTemp_max());
        window.setPressure(dt.getMain().getPressure());
        window.setHumidity(dt.getMain().getHumidity());
        return window;
    }
}
