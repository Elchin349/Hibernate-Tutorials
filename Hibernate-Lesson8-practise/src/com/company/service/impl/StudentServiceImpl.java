package com.company.service.impl;

import com.company.dao.StudentDao;
import com.company.entity.Student;
import com.company.service.StudentService;

import javax.transaction.Transactional;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl() {
        this.studentDao = new StudentDao();
    }

    @Override
    public void saveStudent(Student student) {
        if (student != null) {
            studentDao.saveStudent(student);
        }
    }

    @Override
    @Transactional
    public Student findStudentByStudentId(String studentId) {
        Student student = studentDao.findStudentByStudentId(studentId);
        if (student != null) {
            return student;
        }

        throw new RuntimeException("Student Not Found");
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> studentList = studentDao.findAll();
        if(studentList != null){
            return studentList;
        }
        throw new RuntimeException("Students Not Found");
    }
}
