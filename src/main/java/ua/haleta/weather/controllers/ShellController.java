package ua.haleta.weather.controllers;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;
import ua.haleta.weather.services.AbstractWeatherService;

/**
 * @author Oleksandr Haleta
 * 2021
 */

//@Service
@ShellComponent
public class ShellController {
    private final AbstractWeatherService service;

    public ShellController(AbstractWeatherService service) {
        this.service = service;
    }

    @ShellMethod(key = "1", value = "Get the forecast for your city for 5 days.")
    public void fiveDays(String city) {
        service.fiveDays(city);
    }

    @ShellMethod(key = "2", value = "Get the forecast for your city for today.")
    public void today(String city) {
        service.today(city);
    }
}
