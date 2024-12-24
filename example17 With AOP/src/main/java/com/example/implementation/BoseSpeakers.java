package com.example.implementation;

import com.example.interfaces.Speakers;
import com.example.model.Song;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {
    @Override
    public String makerSound(Song song) {
        return "play music "+song.getTitle()+ " by "+song.getSingerName()+ " Bose Speakers are playing the Music";

    }
}
