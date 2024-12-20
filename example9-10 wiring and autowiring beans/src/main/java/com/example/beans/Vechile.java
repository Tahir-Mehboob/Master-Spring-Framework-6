package com.example.beans;

// adding @Component to create auto object  creation and return bean itself

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// remove this @component b/c
// spring will not create bean itself we create bean programmatically
//@Component

public class Vechile {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    The @PostConstruct annotation, part of the Common Annotations API,is used to mark a methodthat should
    be executed after a bean is fully constructed and initialized by the Spring IoC
    container.This is particularly useful for performing initialization tasks that cannot be done in
    the constructor or setter
     methods .*/

    /*@PostConstruct
    public void initialize(){
        this.name = "Honda";
    }*/


    /*
            @PreDestroy

        In Spring Framework, the @PreDestroy annotation is a powerful tool for managing the lifecycle of beans.
         It's used to specify a method that should be executed just before a bean is removed from the Spring container.
         This is crucial for performing cleanup tasks,
     */
    @PreDestroy
    public void destroy(){
        System.out.println("Destroying Vechile Bean") ;
    }




    // create one more method that print hello

    public void printHello() {
        System.out.println("Hello  from component  Vechile Bean" );
    }

}
