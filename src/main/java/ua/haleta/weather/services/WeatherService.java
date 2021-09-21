package ua.haleta.weather.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ua.haleta.weather.dto.CurrentWeatherDto;

/**
 * @author Oleksandr Haleta
 * 2021
 */

@Service
public class WeatherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);
    private final String URI = "api.openweathermap.org/data/2.5";
    private final String API_ID = "2165181b533b1e072f2c691a3be8971d";

    private WebClient webClient;

    public WeatherService() {
        this.webClient = WebClient.create(URI);
    }

    public /*Mono<CurrentWeatherDto>*/CurrentWeatherDto weatherForecast(String city) {
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = webClient.post();
        WebClient.RequestBodySpec bodySpec = uriSpec.uri("/weather?units=metric&q=Chicago&appid={}"/*, city*/, API_ID);
        CurrentWeatherDto currentWeatherDto = bodySpec.retrieve()
                .bodyToMono(CurrentWeatherDto.class).block();
        assert currentWeatherDto != null;
        LOGGER.info(currentWeatherDto.toString());
        return currentWeatherDto;
    }
}
