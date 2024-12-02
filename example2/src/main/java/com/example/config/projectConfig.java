package com.example.config;

import com.example.beans.Vechile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class projectConfig {

    // Creating Multiple Objects by creating
    // NoUniqueBeanDefinitionException
    @Bean
    Vechile vechile1(){
        var vechile = new Vechile();
        vechile.setName("Audi E-tron");
        return vechile;
    }

    @Bean
    Vechile vechile2(){
        var vechile = new Vechile();
        vechile.setName("Honda Civic");
        return vechile;
    }

    @Bean
    Vechile vechile3(){
        var vechile = new Vechile();
        vechile.setName("Tesla Mocel X");
        return vechile;
    }

    @Bean
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
    }


}
