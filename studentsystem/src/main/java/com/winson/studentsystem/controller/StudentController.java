package com.winson.studentsystem.controller;

import com.winson.studentsystem.model.Student;
import com.winson.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController annotation gets the responseBody and controller at the same time
@RestController
@RequestMapping("/student")
// Need this annotation to bypass CORS error: "Access to fetch at 'http://localhost:8080/student/add' from origin 'http://localhost:3000' has been blocked by CORS policy:"
@CrossOrigin
public class StudentController {
    // injecting StudentService
    @Autowired
    private StudentService studentService;

// code to save the data into database
    @PostMapping("/add")
    public String add(@RequestBody Student student){
        //method to save
        studentService.saveStudent(student);
        // written message
        return "New student is added";
    }

    // code to retrive data
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        // returning list of students
        return studentService.getAllStudents();
    }
}

// controller for mapping all the http methods such as get and post