package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.model.Song;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component  // with the help of this
public class VehicleServices {

    private static final Log log = LogFactory.getLog(VehicleServices.class);
    //  enable loging to this class
    private Logger logger = Logger.getLogger(VehicleServices.class.getName());

    // lets (DI with the help of @autowired) with Speaker for making relationship above class
    @Autowired
    private Speakers speakers;

    // creating DI using setter injection
    private Tyres tyres;

    // this method responsible for when we call this method they depend on speaker and get primary bean
    // which we set

    /**
     * Adding Non- functional requirment for below method
     * method execution time and additional logs
     * @param vehicleStared
     * @param song
     * @author Tahir Mehboob
     */

    public String playMusic(boolean vehicleStared , Song song){

        // without Aop code started
        Instant start = Instant.now();
        logger.info("Methods execution start ");

        // apply validation
        String music = null;
        if(vehicleStared){
            music = speakers.makerSound(song);
        }else {
            logger.log(Level.SEVERE,"Vehicle not started to perform the operation");
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to Methods execution"+timeElapsed);

        // ended without aop code

       // String music = speakers.makerSound(song);
        //System.out.println(music);
        return music;
    }

    // below mehtod depend on Tyre dependency and which get primary bean
    public void moveVehicle(boolean VehicleStared){
        String move = tyres.rotate();
        System.out.println(move);
    }

    // adding one more method for this AOP example

    public String applyBrake(boolean VehicleStared){
       return tyres.stop();
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
