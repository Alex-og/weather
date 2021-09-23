package ua.haleta.weather.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Data
public class WeatherMapDTO {
    private String cod;
    private BigDecimal message;
    private Integer cnt;
    private List<WeatherMapTimeDTO> list;
    private City city;
}
