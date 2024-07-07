package com.login.login.controller;

import com.login.login.repository.Student;
import com.login.login.service.LoginService;
import com.login.login.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private StudentService ss;

    @PostMapping("/login")
    public String login(@RequestBody Student student) {
        if (loginService.login(student)) {
            return "OK: Login exitoso";
        } else {
            return "NO: Credenciales inválidas";
        }
    }

    @PostMapping("/secondFactor/{factor}")
    public String secondFacto(@RequestBody Student student, @PathVariable int factor) {
        if (loginService.secondFactor(factor)) {
            return "OK: Segundo Factor Exitoso";
        } else {
            return "NO: Segundo Factor falló";
        }
    }

    @PostMapping("/registrar")
    public String secondFacto(@RequestBody Student student) {
        return ss.addStudent(student);
    }
}
