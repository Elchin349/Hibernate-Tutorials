package com.company.studentservice;

import com.company.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class GetStudentAndCourse {

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
            session.beginTransaction();

            // Misal data base dan id i 6 olan Student i course id leri 6 ci id e uygun gelenleri secib goturur
            // one to many e oxsadasa amma burda mesele orasindadiki bu kurlar bir telebye mexsus deyil ona gore
            //  many to many yazdiq
            Student student = session.get(Student.class,6L);
            System.out.println(student);

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
