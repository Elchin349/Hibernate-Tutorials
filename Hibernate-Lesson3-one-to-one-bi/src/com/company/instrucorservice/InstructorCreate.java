package com.company.instrucorservice;

import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorCreate {

    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try{
            Instructor instructor = new Instructor("Elchin","Akbarov","elchin@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("myYoutubeChannel","www.javamirt.com");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("SAVED");
        }finally {

            sessionFactory.close();
        }
    }
}
