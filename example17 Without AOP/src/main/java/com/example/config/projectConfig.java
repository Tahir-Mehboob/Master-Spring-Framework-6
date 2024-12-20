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
@ComponentScan(basePackages = {"com.example.implementation",
                                "com.example.services"
                                 })

@ComponentScan(basePackageClasses = {com.example.beans.Vechile.class ,
                                    com.example.beans.Person.class
                                    })

public class projectConfig {
    // Wiring and autowiring example here

    // Example 12 @autowired 3 approaches use

    // use 1 approach create 3 beans with different name 1,2,3
    // and autowired in Person class for DI making Relationship by bean name

   /* @Bean
    public Vechile vechile1(){
        var v = new Vechile();
        v.setName("Audi Vehicle 1");
        return v;
    }

    @Bean
    @Primary            // this is 2nd approach of Bean @autowiring using primary
    public Vechile vechile2(){
        var v = new Vechile();
        v.setName("Ferrai Vehicle 2");
        return v;
    }

    @Bean
    public Vechile vechile3(){
        var v = new Vechile();
        v.setName("Tesla Vehicle 3");
        return v;
    }*/

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
