package com.eazybytes.example21_SpringBoot.model;

import lombok.Data;

@Data
public class Holiday {

    // create fields
    private final String day;
    private final String reason;
    private final Type type;

    // Create Enum
    public enum Type{
        FESTIVAL,FEDERAL
    }

}
