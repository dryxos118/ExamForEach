package com.example.javabarapp.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegisterDto {
    private String first_name;
    private String last_name;
    private String mail;
    private String password;
}
