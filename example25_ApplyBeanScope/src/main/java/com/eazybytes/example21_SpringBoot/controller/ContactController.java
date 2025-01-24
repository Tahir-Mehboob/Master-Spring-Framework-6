package com.eazybytes.example21_SpringBoot.controller;

import com.eazybytes.example21_SpringBoot.model.Contact;
import com.eazybytes.example21_SpringBoot.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
public class ContactController {

    // Enabling Logging in this class
   // final static Logger log = Logger.getLogger(String.valueOf(ContactController.class));

    private final ContactService contactService;

    // once controller class is ready Inject into controller layer
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value="/contact")
    public String displayContactForm(Model theModel){
        theModel.addAttribute("contact", new Contact());
        return "contact.html";
        }

    /* @RequestMapping(value="/saveMsg", method = POST)
    public ModelAndView sendMsg(@RequestParam String name,@RequestParam String mobileNum ,@RequestParam String email
     ,@RequestParam String subject ,@RequestParam String message ){

        // if you have 20 fields then @RequestParam parameters is not apply b/c it is lendthy process
         // solution to create POJO class to deal with large no of fields

        log.info("Name : "+name);
        log.info("Mobile Number : "+mobileNum);
        log.info("Email : "+email);
        log.info("Subject : "+subject);
        log.info("Message :"+message);

        // Why we use ModelAndView
         //Use it when you want to combine both the view name and data in a single object,
         // especially in older or simple Spring MVC setups.

        return new ModelAndView("redirect:/contact");
     }
    }*/

    // using Pojo object to save data into db with the help of service layer

@RequestMapping(value="/saveMsg",method = POST)
public String saveContact(@Valid @ModelAttribute("contact") Contact contact , Errors errors){
    if(errors.hasErrors()){
        log.info("Contact form validation error"+errors.toString());
        return "contact.html";
    }
    // once controller class is ready Inject into controller layer
    log.info("name "+contact.getName());
    contactService.saveContactDetails(contact);
    // return new contact page
    return "redirect:/contact";
}
}
