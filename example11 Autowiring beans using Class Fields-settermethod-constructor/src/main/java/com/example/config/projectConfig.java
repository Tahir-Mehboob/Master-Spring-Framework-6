package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vechile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process  
 the class and generate Spring Beans
to be used in the application.

To tell Spring it needs to search for classes annotated
with stereotype annotations, we use the @ComponentScan annotation over the configuration
class.  

*/

@Configuration
@ComponentScan(basePackages = "com.example.beans")

public class projectConfig {
    // Wiring and autowiring example here

    // create first bean with the help of @Bean anno and pojo vechile class
    /*@Bean
    public Vechile vechile() {
        var vechile = new Vechile();
        vechile.setName("Honda Civic X");
        return vechile;
    }

    // create second bean which is Person with the help of @Bean anno and Person class
    @Bean
    public Person person(Vechile vechile) {
        // example 9 public Person person(){
        var person = new Person();
        person.setName("Tahir Mehboob");
        // below line create wiring blw vechile and person bean
        // person dependency on vechile
        // Not recommand way to wire bean in this way
       // example 9 person.setVechile(vechile());
        // example 10 person.setVechile(vechile));
        return person;
    }*/

 ///////////////////////

    // Creating Multiple Objects by creating
    // NoUniqueBeanDefinitionException

    /*
            no need to create manully object creation
            using @Component and @ComponentScan(basePackage ="")
     */

/*    @Bean(value = "audiVechile")
    Vechile vechile1(){
        var vechile = new Vechile();
        vechile.setName("Audi E-tron");
        return vechile;
    }

    @Bean(name="hondaVechile")
    Vechile vechile2(){
        var vechile = new Vechile();
        vechile.setName("Honda Civic");
        return vechile;
    }

    @Bean("tesla")
    Vechile vechile3(){
        var vechile = new Vechile();
        vechile.setName("Tesla Mocel X");
        return vechile;
    }
    @Primary
    @Bean("bugo")
    Vechile vechile4(){
        var vechile = new Vechile();
        vechile.setName("Bugittii");
        return vechile;
    }

    // Example 1 tasks
    @Bean
    String sayHello(){
        return "Hello World";
    }

    @Bean
    Integer number(){
        return 12;
    }*/
}