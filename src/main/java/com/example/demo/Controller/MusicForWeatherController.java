package com.example.demo.Controller;

import com.example.demo.Model.Location;
import com.example.demo.Model.Weather;
import com.example.demo.Service.GetMusicForCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
//@RequestMapping("/")
public class MusicForWeatherController {

//    @Autowired
//    WeatherMusicRepository weatherRepo;

    @Autowired
    GetMusicForCity getMusicForCity;

    @PostMapping("/getMusicForWeather")
    public String submitForm(@ModelAttribute("location") Location location) {

        Weather wm = getMusicForCity.getWeatherByLocation(location);
//        System.out.println(wm.getId());
//        System.out.println(wm.getMusic());
        System.out.println(wm.toString());

        System.out.println("Location:" + location.getName());

        return "music";
    }
    @GetMapping("/")
    public String index(Model model) {
        System.out.println("Inside Index method");
        model.addAttribute("location",  new Location());
        return "indexWeather";
    }

    @RequestMapping("/getMusic")
    public String getMusic(){
        System.out.println("Sunny");
        return "Sunny";
    }
}
