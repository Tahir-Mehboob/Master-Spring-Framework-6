package com.example.implementation;

import com.example.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {
    @Override
    public String makerSound() {
        return "Bose Speakers are playing the Music";
    }
}
