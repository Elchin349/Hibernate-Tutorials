package com.company.instrucorservice;

import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadInstructorDetail {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {

            /**
             * Bu sefer biz Instructor detailda 2 terefli elaqe qurdugumuz ucun detaili cagirmaqla instructoru da cagira bilirik
             *
             */
            session.beginTransaction();

            long id = 1L;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());

            session.delete(instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("DONE");
        } finally {

            sessionFactory.close();
        }
    }
}
