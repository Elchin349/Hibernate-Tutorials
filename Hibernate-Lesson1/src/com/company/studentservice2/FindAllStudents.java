package com.company.studentservice2;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FindAllStudents {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            List<Student> studentList = (List<Student>) session.createQuery("from Student ").list();
            for (Student s: studentList) {
                System.out.println(s);
            }

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
