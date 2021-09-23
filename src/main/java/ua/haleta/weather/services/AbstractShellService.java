package ua.haleta.weather.services;

import org.springframework.shell.standard.ShellMethod;

/**
 * @author Oleksandr Haleta
 * 2021
 */
public interface AbstractShellService {
    @ShellMethod("Get the forecast for your city for 40 days.")
    void fortyDays(String city);

    @ShellMethod("Get the forecast for your city for today.")
    void today(String city);
}
