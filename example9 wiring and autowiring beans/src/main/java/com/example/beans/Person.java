package com.example.beans;

public class Person {
    private String name;
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
