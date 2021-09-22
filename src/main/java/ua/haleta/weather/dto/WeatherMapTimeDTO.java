package ua.haleta.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Data
public class WeatherMapTimeDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dt_txt")
    private LocalDateTime dt;
    private WeatherMapTimeMainDTO main;
}
