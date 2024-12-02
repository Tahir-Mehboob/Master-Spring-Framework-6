package com.example.config;

import com.example.beans.Vechile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = "com.example.beans")
@Service
@Repository
@Controller
public class projectConfig {

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
