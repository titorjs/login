package com.login.login.service;

import com.login.login.repository.Student;
import com.login.login.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private StudentRepository sr;

    public boolean login(Student student){
        Student bd = sr.findByUsername(student.getUsername());

        if (sr == null){
            return false;
        }

        return bd.validatePassword(student.getPassword());
    }

    public boolean secondFactor(int number){
        return true;
    }
}
