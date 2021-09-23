package ua.haleta.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Data
public class City {
    private BigInteger id;
    private String name;
    private Coordinates coord;
    private String country;
    private BigInteger population;
    private BigInteger timezone;
    private BigInteger sunrise;
    private BigInteger sunset;

}

@Data
class Coordinates {
    private BigDecimal lat;
    private BigDecimal lon;
}
