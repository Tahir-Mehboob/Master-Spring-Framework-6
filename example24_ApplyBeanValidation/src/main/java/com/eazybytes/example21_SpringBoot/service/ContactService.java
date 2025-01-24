package com.eazybytes.example21_SpringBoot.service;

import com.eazybytes.example21_SpringBoot.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.logging.Logger;
@Slf4j
@Service
//@RequestScope
@SessionScope
public class ContactService {

    private int counter = 0;

    public ContactService(){
        System.out.println("ContactService Bean Created ..... ");
    }

    // getter and setter for incrementing and checking the Bean Scope using @RequestScope

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


  //  final static Logger log = Logger.getLogger(String.valueOf(ContactService.class));
    /**
     * Save Contact Details into DB
     * @Param Contact
     * @return boolean
     */

    public boolean saveContactDetails(Contact contact) {
        boolean isSaved = true;

        log.info(contact.toString());
        return isSaved;
    }
}
