package com.example.main;

import com.example.beans.Vechile;
import com.example.config.projectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7 {

    public static void main(String[] args) {

        // Creating Object without tracking the spring context
        Vechile vehile = new Vechile();
        vehile.setName("Buggo  Car");
        System.out.println("Vechile Name from non-spring Context " + vehile.getName());

        // below line create spring IOC container or spring context
        var context =  new AnnotationConfigApplicationContext(projectConfig.class);

        // here Example 7 code started
        // create bean programmatically

        Vechile volkswagen = new Vechile();
        volkswagen.setName("volkswagen");
        Supplier<Vechile> volkswagenSupplier =  () -> volkswagen;

        // 2nd approach to create vechile object using lamda expresssion
        // using supplier to return the object

        /*
                Supplier<Vehicle> audiVehicleSupplier = new Supplier<Vehicle>() {
                  @Override
                    public Vehicle get() {
                        Vehicle audiVehicle = new Vehicle();
                        audiVehicle.setName("Audi");
                        return audiVehicle;
                    }
                  };
                  above example without using lamda expression
         */

        Supplier<Vechile> audiVechileSupplier =  () -> {
            Vechile audiVechile = new Vechile();
            audiVechile.setName("audi");
            return audiVechile;
        };

        Random random = new Random();
        int randNumber = random.nextInt(10);
        System.out.println("random Number"+randNumber);

        if(randNumber % 2 == 0 ){
            context.registerBean("volkswagen",Vechile.class,volkswagenSupplier);
        }else {
            context.registerBean("audi",Vechile.class,audiVechileSupplier);
        }

        Vechile volksVechile = null;
        Vechile audi = null;
        try{
            volksVechile = context.getBean("volkswagen",Vechile.class);
        }catch(NoSuchBeanDefinitionException e){
            System.out.println("Error while Creating Volkswagen Vechile");
        }
        try{
            audi = context.getBean("audi",Vechile.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while Creating AudiVechile Vechile");
        }

        if(null != volksVechile){
            System.out.println("\nProgramming Vechile name from spring Context "+volksVechile.getName());
        }else{
            System.out.println("\nProgramming Vechile name from Spring Context "+audi.getName());
        }

        // this is first bean which initalize in project config

        // throw exception of NoUniqueBeanDefinitionException
      //  Vechile veh = context.getBean(Vechile.class);

        // to resolve this passing the name and bean type
       // Vechile veh = context.getBean("audiVechile", Vechile.class);

        // if use @Primary then the above code return define bean method
        // how to fix this simplily retrive the bean from the spring context

        System.out.println("\n--------------@PostConstruct Bean setting the bean name---------------");

        Vechile vehicle = context.getBean(Vechile.class);
            // vehicle.getName set the name which we set in PreConstruct method
        System.out.println("Component Vechile Name from Spring Context is " + vehicle.getName());
        vehicle.printHello();

        // we call destroy method which define in Vechile bean class
        System.out.println("----------@PreDestroy Bean close the bean-----------------  ");
        context.close();

        // this is second bean method which inialize in projectConfig
       /*

        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is : "+hello);
        Integer  num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is : "+num);

        */
    }

}
