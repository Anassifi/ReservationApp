package com.anassifi.service;

import com.anassifi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    void saveStudent(Student theStudent);

    Student getStudent(int theId);

    void deleteStudent(int theId);
}
