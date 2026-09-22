package com.example.SpringJDBCExample.repository;

import com.example.SpringJDBCExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Student> findAll() {

        String sql = "SELECT * FROM student";

        RowMapper<Student> rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student s = new Student();

                s.setRoll(rs.getInt("roll"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));

                return s;
            }
        };

        return jdbc.query(sql, rowMapper);
    }

    public void save(Student student) {

        String sql =
                "INSERT INTO student (roll, name, marks) VALUES (?, ?, ?)";

        int rows = jdbc.update(
                sql,
                student.getRoll(),
                student.getName(),
                student.getMarks()
        );

        System.out.println("save() function called");
        System.out.println(rows + " affected");
    }
}