package ua.haleta.weather.services;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Service
@ShellComponent
public class ShellService {
    private final WeatherService service;

    public ShellService(WeatherService service) {
        this.service = service;
    }

    @ShellMethod("Get the forecast for your city for 40 days.")
    public void forecast(String city) {
        service.fortyDays(city);
    }

    @ShellMethod("Get the forecast for your city for today.")
    public void today(String city) {
        service.today(city);
    }
}
