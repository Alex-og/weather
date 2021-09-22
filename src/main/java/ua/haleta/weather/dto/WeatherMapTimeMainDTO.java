package ua.haleta.weather.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Data
public class WeatherMapTimeMainDTO {

    private BigDecimal temp;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private BigDecimal pressure;
    private BigDecimal sea_level;
    private BigDecimal grnd_level;
    private BigDecimal humidity;
    private BigDecimal temp_kf;
}
