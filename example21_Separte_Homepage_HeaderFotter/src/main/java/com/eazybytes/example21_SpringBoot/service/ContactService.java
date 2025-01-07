package com.eazybytes.example21_SpringBoot.service;

import com.eazybytes.example21_SpringBoot.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Slf4j
@Service
public class ContactService {

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
