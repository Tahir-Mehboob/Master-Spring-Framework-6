package com.eazybytes.example18_SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

   // @RequestMapping("/home")
    @RequestMapping(value={"","/","home"})
    public String displayHomePage(Model model) {
        model.addAttribute("username","Tahir M");
        return "home.html";
    }
}
