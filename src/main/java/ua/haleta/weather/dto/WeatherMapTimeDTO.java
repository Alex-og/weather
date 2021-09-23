package ua.haleta.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

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
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private BigInteger visibility;
    private BigDecimal pop;
}

/*@Data
class WeatherMapTimeMainDTO {
    private BigDecimal temp;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private BigDecimal pressure;
    private BigDecimal sea_level;
    private BigDecimal grnd_level;
    private BigDecimal humidity;
    private BigDecimal temp_kf;
}*/

@Data
class Weather {
    private BigInteger id;
    private String main;
    private String description;
    private String icon;
}

@Data
class Clouds {
    private int clouds;
}

@Data
class Wind {
    private BigDecimal speed;
    private BigDecimal deg;
    private BigDecimal gust;
}
