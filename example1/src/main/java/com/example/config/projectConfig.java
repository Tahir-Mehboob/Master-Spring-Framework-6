package com.example.config;

import com.example.beans.Vechile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class projectConfig {

    @Bean
    Vechile vechile(){
        var vechile = new Vechile();
        vechile.setName("Audi E-tron");
        return vechile;
    }

    @Bean
    String sayHello(){
        return "Hello World";
    }

    @Bean
    Integer number(){
        return 12;
    }


}
