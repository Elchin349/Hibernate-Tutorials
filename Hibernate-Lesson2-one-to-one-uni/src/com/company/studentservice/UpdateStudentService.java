package com.company.studentservice;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentService {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Long id = 1L;
        try{
            /**
             * Update etmek istedikde sadece ide gore melumati tapib
             * ondan sonra neyo deyiseceksense deyisirsen ve commit edib bitrirsen
             * bu sekilde update olunur artiq
             */
            session.beginTransaction();
            Student student = session.get(Student.class,id);
            student.setFirstName("Lale");

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
