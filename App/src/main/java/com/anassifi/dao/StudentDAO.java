package com.anassifi.dao;

import com.anassifi.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();

    void saveStudent(Student theStudent);

    Student getStudent(int theId);

    void deleteStudent(int theId);
}
