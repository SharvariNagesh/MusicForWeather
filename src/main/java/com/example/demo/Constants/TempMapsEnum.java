package com.example.demo.Constants;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Sharvari Nagesh
 * TempMapsEnum stores the temperature ranges for each section. and the playlist id to be played.
 * This constant declaration has been done in one place, so that if any changes needs to be made in the temperature ranges,
 * it is in one place.
 */
public enum TempMapsEnum {

        Hot(30,1000, "Hot","41YYBxyJB4CYKCtmMS3eHg","Party Track"),
        COOL(15,30,"COOL", "62nvBTUMhBmBlF2s0JUht0", "Pop Track"),
        CHILL(10,15,"CHILL","5qbbCEuAMUXuTIlOWrLepY", "Rock Track"),
        FREEZ(-1000,10,"FREEZE","0vY8oLNjKUX4von9rxB3gb", "Classical Track");

        private final int low;
        private final int high;
        private final String tempType;
        private final String track;
        private final String musicType;


    private TempMapsEnum(int low, int high, String tempType, String track, String musicType){
        this.low = low;
        this.high = high;
        this.tempType = tempType;
        this.track = track;
        this.musicType = musicType;
    }

    public int getLow(){
        return low;
    }
    public int getHigh(){
        return high;
    }
    public String getTempType(){
        return tempType;
    }
    public String getTrack(){return track;}

}
