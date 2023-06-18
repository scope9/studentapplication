package com.winson.studentsystem.repository;
import com.winson.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects
public interface StudentRepository extends JpaRepository<Student,Integer> {
}

// repository package is for jpa implementation