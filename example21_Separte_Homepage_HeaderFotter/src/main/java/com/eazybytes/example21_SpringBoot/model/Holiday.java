package com.eazybytes.example21_SpringBoot.model;

public class Holiday {

    // create fields
    private final String day;
    private final String reason;
    private final Type type;

    // Create Enum
    public enum Type{
        FESTIVAL,FEDERAL
    }

    // Create Constuctor
    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    // create getter and setter


    public String getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }

    public Type getType() {
        return type;
    }
}
