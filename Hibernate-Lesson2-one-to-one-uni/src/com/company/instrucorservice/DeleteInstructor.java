package com.company.instrucorservice;

import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {

            // id-e gore sadece instructoru tapiriq ve delete edirik
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1L);
            session.delete(instructor);

            // delete edenden sonra database de baxsaz goreceksizki tekce instructr deyil eyni zamanda detailsdaki melumatlarda pozulub
            session.getTransaction().commit();

            System.out.println("DONE");
        } finally {

            sessionFactory.close();
        }
    }
}
