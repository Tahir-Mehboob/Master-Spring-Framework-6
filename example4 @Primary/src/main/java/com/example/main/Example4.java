package com.example.main;

import com.example.beans.Vechile;
import com.example.config.projectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example4 {
    public static void main(String[] args) {

        // Creating Object without tracking the spring context
        Vechile vehile = new Vechile();
        vehile.setName("Honda City");
        System.out.println("Vechile Name from non-spring Context " + vehile.getName());

        var context =  new AnnotationConfigApplicationContext(projectConfig.class);

        // this is first bean which initalize in project config

        // throw exception of NoUniqueBeanDefinitionException
      //  Vechile veh = context.getBean(Vechile.class);

        // to resolve this passing the name and bean type
       // Vechile veh = context.getBean("audiVechile", Vechile.class);

        // if use @Primary then the above code return define bean method
        // how to fix this simplily retrive the bean from the spring context
        Vechile vehicle = context.getBean(Vechile.class);
        System.out.println("Vechile Name from Spring Context " + vehicle.getName());

        // this is second bean method which inialize in projectConfig

       /*

        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is : "+hello);
        Integer  num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is : "+num);

        */




    }

}
