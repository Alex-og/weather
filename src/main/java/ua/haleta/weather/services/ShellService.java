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
public class ShellService implements AbstractShellService {
    private final AbstractWeatherService service;

    public ShellService(AbstractWeatherService service) {
        this.service = service;
    }

    @Override
    @ShellMethod("Get the forecast for your city for 40 days.")
    public void fortyDays(String city) {
        service.fortyDays(city);
    }

    @Override
    @ShellMethod("Get the forecast for your city for today.")
    public void today(String city) {
        service.today(city);
    }
}
