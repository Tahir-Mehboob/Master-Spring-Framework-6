package com.example.beans;

// adding @Component to create auto object  creation and return bean itself

import org.springframework.stereotype.Component;

@Component
public class Vechile {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // create one more method that print hello

    public void printHello() {
        System.out.println("Hello Hello  from component  Vechile Bean" );
    }

}
