package com.example.demo.Controller;

import com.example.demo.Model.Location;
import com.example.demo.Model.Music;
import com.example.demo.Service.GetMusicForLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.validation.Valid;

@Controller
public class MusicForWeatherController {
    @Autowired
    GetMusicForLocation getMusicForLocation;

    @PostMapping("/getMusicForWeather")
    public String submitForm( Model model, @ModelAttribute("location") @Valid Location location,  BindingResult result) {
        if(result.hasErrors()) {
            return "indexPage";
        }
        Music music =  getMusicForLocation.getMusicForTheLocation(location);
        model.addAttribute("music", music);
        System.out.println("Music model: " + music.toString());
        return "music";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("location",  new Location());
        return "indexPage";
    }

    @RequestMapping("/getMusic")
    public String getMusic(){
        System.out.println("Sunny");
        return "Sunny";
    }
    @RequestMapping("/test")
    public String getTest(){
        System.out.println("test.html");
        return "test";
    }
}
