package com.winson.studentsystem.service;


import com.winson.studentsystem.model.Student;

import java.util.List;

public interface StudentService {
    // this method is used to save data in the POST request
    public Student saveStudent(Student student);
    // this method is used to retrieve data in the GET request
    public List<Student> getAllStudents();
}
