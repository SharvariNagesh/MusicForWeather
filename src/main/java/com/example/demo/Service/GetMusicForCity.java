package com.example.demo.Service;

import com.example.demo.Model.Location;
import com.example.demo.Model.Weather;
import com.example.demo.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GetMusicForCity {
    //@Autowired
//    private WeatherMusicRepository weatherRepo ;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private Utilities utilities;

    public Weather getWeatherByLocation(Location location){
        String baseUri = "http://api.openweathermap.org/data/2.5/weather?units=metric&appid=b77e07f479efe92156376a8b07640ced";

        String uri ="";
        if(utilities.isEmptyString(location.getName()) == false) {
            uri = baseUri + "&q=" + location.getName();
        } else if(location.getLongitude() > 0 & location.getLatitude() > 0){
            uri = baseUri + "&lat=" + location.getLatitude() + "&lon="+ location.getLongitude();
        }//TODO : implement else case
        Weather weather = webClientBuilder.build().get().uri(uri)
                .retrieve()
                .bodyToMono(Weather.class)
                .block();
        System.out.println( weather.toString());
        return weather;
    }
//    public Weather getMusic(Weather weather) {
//        Weather weather = webClientBuilder.build().get().uri("http://api.openweathermap.org/data/2.5/weather?units=metric&appid=b77e07f479efe92156376a8b07640ced&lat=" + location.getLatitude() + "&lon=" + location.getLongitude())
//                .retrieve()
//                .bodyToMono(Weather.class)
//                .block();
//        System.out.println( weather.toString());
//        return weather;
//    }
//    public Weather getMusic(String locationName){
//
//    }
}
