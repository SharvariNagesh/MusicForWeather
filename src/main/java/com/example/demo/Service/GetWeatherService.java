package com.example.demo.Service;

import com.example.demo.Model.Location;
import com.example.demo.Model.Weather;
import com.example.demo.Util.Utilities;
import com.example.demo.custom.Exception.WrongInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
/**
 * @author: Sharvari Nagesh
 * Weather Service. This is responsible for calling openweather API and get the weather details.
 */

@Service
public class GetWeatherService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private Utilities utilities;

    public GetWeatherService(){}

    public Weather getWeatherByLocation(Location location) {
        String baseUri = "http://api.openweathermap.org/data/2.5/weather?units=metric&appid=b77e07f479efe92156376a8b07640ced";

        String uri = "";
        if (utilities.isEmptyString(location.getName()) == false) {
            uri = baseUri + "&q=" + location.getName();
        } else if (utilities.isEmptyString(location.getLongitude()) == false  & utilities.isEmptyString(location.getLatitude()) == false) {
            uri = baseUri + "&lat=" + location.getLatitude() + "&lon=" + location.getLongitude();
        } else {
            throw new WrongInputException("601", "Input Fields are empty");
        }

        Weather weather = webClientBuilder.build().get().uri(uri)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> {
                    return Mono.error( new WrongInputException("4xx","City or Lat/Lon not found: " + location.getName() +" (" +location.getLatitude() +"/" + location.getLongitude() +")" ));
                })
                .bodyToMono(Weather.class)
                .block();
        System.out.println(weather.toString());
        return weather;

    }
}
