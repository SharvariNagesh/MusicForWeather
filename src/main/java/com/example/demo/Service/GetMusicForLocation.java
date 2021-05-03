package com.example.demo.Service;

import com.example.demo.Constants.TempMapsEnum;
import com.example.demo.Model.Location;
import com.example.demo.Model.Music;
import com.example.demo.Model.Weather;
import com.example.demo.Util.Utilities;
import com.example.demo.custom.Exception.WrongInputException;
import com.wrapper.spotify.model_objects.specification.Playlist;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GetMusicForLocation {
    @Autowired
    private SpotifyService spotifyService;

    @Autowired
    private GetWeatherService getWeatherService;

    public Music getMusicForTheLocation(Location location){
        Location location1 = new Location();
        Weather weather = getWeatherService.getWeatherByLocation(location);
        Music music = spotifyService.get_album(weather.getMain().getTemp());
        location1.setName(weather.getName());
        location1.setLongitude(weather.getCoord().getLon());
        location1.setLatitude(weather.getCoord().getLat());
        music.setLocation(location1);
        music.setTemperature(weather.getMain());
        return music;
    }
}
