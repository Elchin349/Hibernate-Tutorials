package com.company.instrucorservice;

import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInstructor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {

            // ide gore sadece instructoru tapiriq ve set elemeknen yeterlidki update olunsun
            // hetta buna gore ayrica query yazib instructor deyaili da cagirmaq lazim deyil
            //  Hibernate frame work bizim ucun bu qeder sade bir hala getirir ki artiq jdbc de etdiyiniz kimi uzun uzun kodlar yazmiyasiniz
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1L);
            instructor.setFirstName("Rahib");
            instructor.getInstructorDetail().setWebsite("dedebaba.com");

            session.getTransaction().commit();

            System.out.println("DONE");
        } finally {

            sessionFactory.close();
        }
    }
}
