package com.example.SpringJDBCExample;

import com.example.SpringJDBCExample.model.Student;
import com.example.SpringJDBCExample.repository.StudentRepo;
import com.example.SpringJDBCExample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcExampleApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setRoll(105);
		student.setMarks(100);
		student.setName("Aditya Vikram Kirtania");

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(student);

		List<Student> students = service.getStudents();
		System.out.println(students);



	}

}
