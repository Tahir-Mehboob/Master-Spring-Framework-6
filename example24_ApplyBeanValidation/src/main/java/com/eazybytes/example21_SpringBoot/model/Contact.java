package com.eazybytes.example21_SpringBoot.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Contact {

    @NotNull(message = "Name must not be null")
    @Size(message="Name must be at least 3 Characters long")
    private String name;

    @NotBlank(message = "Mobile Number must be not null")
    @Pattern(regexp="(^$|[0-9]{10})",message="Mobile Number must be 10 digits" )
    private String mobileNum;

    @NotBlank(message = "Email must be not blank")
    @Email(message = "Please provide a valid email address")
    private String email;


    @NotBlank(message = "Subject must not be blank")
    @Size(min=5,message="Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min=10 ,message = "Message must be at least 10 characters long ")
    private String message;

}
