package com.company.studentservice2;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class GetStudentByFinCode {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            String  finCode = "wo12q8";
            Query query = session.createQuery("from Student where finCode=  '" + finCode +"'");
            System.out.println(query.getSingleResult());
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }

}
