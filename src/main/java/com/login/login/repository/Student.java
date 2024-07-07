package com.login.login.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String username;
    private String password;
    private String name;

    public boolean validatePassword(String password){
        return this.password.equals(password);
    }
}