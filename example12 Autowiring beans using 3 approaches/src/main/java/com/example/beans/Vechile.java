package com.example.beans;

// adding @Component to create auto object  creation and return bean itself

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// remove this @component b/c
// spring will not create bean itself we create bean programmatically
//@Component
public class Vechile {

        //for generate circular dependency exception
        // both vechicle and person depend to each other that's why spring ioc confuse
        // first create vehicle or person then autowired they throw circular exception
      /*  @Autowired
        private Person person;*/


    // in Example 12 using @autowired 3 approaches we not use @component b/c
    // we create multiple beans with same class type
    // by defualt spring ioc container use class type
    // but we try to use @autwired by bean name that's why we use @bean

  /*  public Vechile() {
        System.out.println("Vechile bean created by spring framework");
    }
 */   // here we define the name b/c in @bean case we not then we use @PostContruct to inialitize the values
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

    @Override
    public String toString() {
        return "Vechile{" +
                "name='" + name + '\'' +
                '}';
    }
}
