package com.example.demo.Controller;

import com.example.demo.Model.Location;
import com.example.demo.Model.Music;
import com.example.demo.Service.GetMusicForLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import javax.validation.Valid;

/**
 * @author : Sharvari Nagesh
 * REST Controller class, which handles rest call requests.
 */
@Controller
public class MusicForWeatherController {
    @Autowired
    GetMusicForLocation getMusicForLocation;

    /**
     *
     * @param location
     * @param result
     * @param model
     * @return music Model to music.html file.
     * This function gets the location details from the user. It uses services in the service layer to get a playlist to play.
     */
    @PostMapping("/getMusicForWeather")
    public String submitForm(@ModelAttribute("location") @Valid Location location, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return "indexPage";
        }
        Music music =  getMusicForLocation.getMusicForTheLocation(location);
        model.addAttribute("musicForLocation", music);
        System.out.println("Music model: " + music.toString());
        return "music";
    }

    /**
     * @param model
     * @return an empty location model to be filled by the user.
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("location",  new Location());
        return "indexPage";
    }

}
