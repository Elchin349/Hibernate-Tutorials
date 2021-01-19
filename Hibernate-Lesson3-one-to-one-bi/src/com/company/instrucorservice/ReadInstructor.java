package com.company.instrucorservice;

import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {

            //  instructor i id e ile cagirmagimiz yeterlidiki onunla birlikde instructorDetail table in daki melumatlarida
            // getire bilek
            session.beginTransaction();

            long id = 1L; // id ini bazadan baxib gotururem
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println(instructor);
            System.out.println(instructor.getInstructorDetail());

            session.getTransaction().commit();

            System.out.println("DONE");
        } finally {

            sessionFactory.close();
        }
    }
}
