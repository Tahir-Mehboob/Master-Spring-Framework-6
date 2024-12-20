package com.example.implementation;

import com.example.interfaces.Speakers;
import com.example.model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {

    @Override
    public String makerSound(Song song) {
        return  "playing the Song "+song.getTitle()+" by "+song.getSingerName()+" with Sony speakers ";

    }

}
