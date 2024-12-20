package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @componet use for simple pojo convert into bean
@Component
public class Person {

    // but there is only one constuctor in bean class /than @Autowired is optional
    @Autowired
    public Person(Vechile vechile) {
        System.out.println("Person bean created by spring framework");
        this.vechile = vechile;
    }
     // here we define the name b/c if we not then we use @PostContruct to inialitize the values
    private String name="lucy";

    // below anno use for telling spring person has dependency on vechile
    //by defualt is required value is true
    // if we change into false the dependency is optional
    // this is called class field @autowired annotation
   // @Autowired(required=false)
    private Vechile vechile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vechile getVechile() {
        return vechile;
    }

    // by default it is true
    // to make it dependency optional use false
    // example 5 @autowire
  //  @Autowired(required=true)
    public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "vechile=" + vechile +
                '}';
    }
}
