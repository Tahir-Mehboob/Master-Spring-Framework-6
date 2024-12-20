package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // with the help of this
public class VehicleServices {

    // lets (DI with the help of @autowired) with Speaker for making relationship above class
    @Autowired
    private Speakers speakers;

    // creating DI using setter injection
    private Tyres tyres;

    // this method responsible for when we call this method they depend on speaker and get primary bean
    // which we set

    public void playMusic(){
        String music = speakers.makerSound();
        System.out.println(music);
    }

    // below mehtod depend on Tyre dependency and which get primary bean
    public void moveVehicle(){
        String move = tyres.rotate();
        System.out.println(move);
    }

    // adding this b/c both beans having same type so which one inject
    /*public VehicleServices(Speakers speaker) {
        this.speakers = speaker;
    }*/

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyre) {
        this.tyres = tyre;
    }

}
