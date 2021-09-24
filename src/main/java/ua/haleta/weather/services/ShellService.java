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
    private final AbstractWeatherService service;

    public ShellService(AbstractWeatherService service) {
        this.service = service;
    }

    @ShellMethod(key = "1", value = "Get the forecast for your city for 5 days.")
    public void fortyDays(String city) {
        service.fiveDays(city);
    }

    @ShellMethod(key = "2", value = "Get the forecast for your city for today.")
    public void today(String city) {
        service.today(city);
    }
}
