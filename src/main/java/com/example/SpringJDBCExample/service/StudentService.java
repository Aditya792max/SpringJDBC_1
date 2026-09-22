package com.example.SpringJDBCExample.service;

import com.example.SpringJDBCExample.model.Student;
import com.example.SpringJDBCExample.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Autowired
    private StudentRepo studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
        System.out.println("addStudent() function called");
    }

    public List<Student> getStudents() {
        System.out.println("getStudents() function called");
        return studentRepo.findAll();
    }
}
