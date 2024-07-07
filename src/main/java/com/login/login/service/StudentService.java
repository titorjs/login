package com.login.login.service;

import com.login.login.repository.Student;
import com.login.login.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public String addStudent(Student student){
        try {
            if (studentRepository.findByUsername(student.getUsername()) != null) {
                return "El estudiante con nombre de usuario {} ya existe";
            }
            studentRepository.save(student);
            return "Registrado correctamente";
        } catch (Exception e) {
            return "Error al guardar el estudiante";
        }
    }
}
