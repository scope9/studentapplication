package com.winson.studentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// springboot creates the table called student (in file student service) and inside this table the attributes id, address, and name are the columns created by hibernate in file application properties
public class StudentsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsystemApplication.class, args);
	}

}
