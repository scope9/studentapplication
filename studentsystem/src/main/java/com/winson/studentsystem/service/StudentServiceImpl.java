package com.winson.studentsystem.service;

import com.winson.studentsystem.model.Student;
import com.winson.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @service hold business logic in the Service layer
public class StudentServiceImpl implements StudentService {

    // In order to autowire a class you need to have that class decorated with @Service or @Component in order for Spring to inject it into StudentRepository. Otherwise without @Service annotation the spring error will be "Field studentService in StudentController required a bean in file StudentService that could not be found"
    @Autowired
    private StudentRepository studentRepository;

    @Override
    // implementing saveStudent from file StudentService. Override method for saveStudent
    public Student saveStudent(Student student) {
        // For POST
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        // For GET which gets all the students in the database
        return studentRepository.findAll();
    }
}

// These are the packages and class that will be using to create the backend application