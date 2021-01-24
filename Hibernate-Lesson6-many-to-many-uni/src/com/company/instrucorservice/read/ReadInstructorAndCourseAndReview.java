package com.company.instrucorservice.read;

import com.company.entity.Course;
import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import com.company.entity.Review;
import com.company.util.PrintInstructors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadInstructorAndCourseAndReview {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {

            Long id = 2L;

            session.beginTransaction();

            // instructoru cagirriq ve butun ona bagli olan table larda gelir
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(PrintInstructors.printInstructor(instructor));


            session.getTransaction().commit();

            System.out.println("DONE");
        } finally {

            sessionFactory.close();
        }
    }
}
