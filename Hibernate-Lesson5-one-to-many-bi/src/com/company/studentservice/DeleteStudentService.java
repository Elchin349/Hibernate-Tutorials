package com.company.studentservice;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentService {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        // id e gore tapib delete edirik
        Long id = 4L;
        try{
            session.beginTransaction();
            Student student = session.get(Student.class,id);
            System.out.println(student);
            session.delete(student);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
