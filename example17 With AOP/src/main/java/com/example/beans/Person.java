package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @componet use for simple pojo convert into bean
@Component(value="personBean")
public class Person {

    // here we define the name b/c if we not then we use @PostContruct to inialitize the values
    private String name="lucy";
    private  final Vechile vechile;

    // but there is only one constuctor in bean class /than @Autowired is optional
    // here we use constuctor style autowiring approach

    // example 12 here we use 1 approach by passing using method bean name which define in Vechile class
    // use 3 approach @qualifier in constructor parameter
    @Autowired
    public Person(Vechile vechile) {
        System.out.println("Person bean created by spring framework");
        this.vechile = vechile;
    }

    // below anno use for telling spring person has dependency on vechile
    //by defualt is required value is true
    // if we change into false the dependency is optional
    // this is called class field @autowired annotation
   // @Autowired(required=false)
    // we can also use @Qualifer in class filed which is 3rd approach for known sprin ioc which bean to autowired


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
    // when we set class field as final then no need to create
    // setter method otherwise throw an error
    /*public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "vechile=" + vechile +
                '}';
    }
}
