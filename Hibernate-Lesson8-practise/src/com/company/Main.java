package com.company;

import com.company.entity.Address;
import com.company.entity.Student;
import com.company.entity.Subject;
import com.company.service.StudentService;
import com.company.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {

        /**
         *  StudentService static eledimki esas isimize fokuslanaq normalda bele yazilmir
         *  spring texnologiyasinda ki kimi dependency injection olur
         *
         *  burda ilk once men Student yaradiram derslerini adresini yaziram
         *
         */
//        Student student = new Student("Rasim", "Elibeyov", "#123465", "Computer Science");
//        Address address = new Address("Azerbijan", "Baku", "Nerimanov", "hbnerk", "125A");
//        List<Subject> subjects = new ArrayList<>();
//        subjects.add(new Subject("Java", "Islam Bayramov", 96));
//        subjects.add(new Subject("NetWork", "Vuqar Ibadli", 56));
//        subjects.add(new Subject("Data Structure", "Pasa Qulamov", 36));
//        subjects.add(new Subject("C++", "Aqil Musayev", 120));
//
//        student.setAddress(address);
//        student.setSubjectList(subjects);

      //  findStudent("#125565");
        findAllStudents();

    }

    public static void saveStudent(Student student) {
        System.out.println("\n============================================\n");
        System.out.println("* * * * * STUDENT SAVE * * * * *");
        studentService.saveStudent(student);
    }

    public static void findStudent(String studentId) {
        System.out.println("\n============================================\n");
        System.out.println("* * * * * FIND STUDENT BY STUDENT ID * * * * *");
        Student student1 = studentService.findStudentByStudentId(studentId);
        System.out.println(student1);
        System.out.println(student1.getAddress());
        List<Subject> subjects1 = student1.getSubjectList();
        for (Subject s : subjects1) {
            System.out.println(s);
        }
    }

    public static void findAllStudents() {
        System.out.println("* * * * * Find All Student * * * * *");
        // System.out.println(Arrays.toString(studentService.findAllStudents().toArray()));
        for (Student s : studentService.findAllStudents()) {
            System.out.println(s);
            for (Subject sb : s.getSubjectList()) {
                System.out.println(sb);
            }
        }

        System.out.println("\n============================================\n");
    }
}
