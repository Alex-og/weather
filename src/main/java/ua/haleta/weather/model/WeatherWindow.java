package ua.haleta.weather.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Data
public class WeatherWindow {
    private String city;
    private LocalDateTime dt;
    private BigDecimal temp;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private BigDecimal pressure;
    private BigDecimal humidity;

    @Override
    public String toString() {
        return "city='" + city + '\'' +
                ", date=" + dt + "\n" +
                "-- temp=" + temp + "\n" +
                "-- temp_min=" + temp_min + "\n" +
                "-- temp_max=" + temp_max + "\n" +
                "-- pressure=" + pressure + "\n" +
                "-- humidity=" + humidity + "\n";
    }
}
