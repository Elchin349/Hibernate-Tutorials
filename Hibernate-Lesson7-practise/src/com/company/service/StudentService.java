package com.company.service;

import com.company.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student findStudentByStudentId(String studentId);

    List<Student> findAllStudents();
}
