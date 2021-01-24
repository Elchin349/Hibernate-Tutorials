package com.company.studentservice;

import com.company.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CreateStudentAndCourse {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try{

            Student student = new Student("Kenan","Usubov","wr34er");

            List<Course> courses = new ArrayList<>();
            courses.add(new Course("Hibernate tutorial"));
            courses.add(new Course("Spring tutorial"));
            courses.add(new Course("Java tutorial"));

            student.setCourses(courses);

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Save");
        }finally {
            sessionFactory.close();
        }
    }
}
