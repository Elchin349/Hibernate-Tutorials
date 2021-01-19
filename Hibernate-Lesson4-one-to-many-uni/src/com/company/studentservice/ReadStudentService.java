package com.company.studentservice;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
// Database den melumatlari id e gore oxuyacayiq
// Entity de biz id i Long qebul etdiyimize gore id nin tipide ona uygun olmalidi
public class ReadStudentService {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Long id = 1L;

        try{
            session.beginTransaction();

            Student student = session.get(Student.class,id);

            System.out.println(student);

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
