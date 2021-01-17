package com.company.studentservice2;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class GetStudentByFirstName {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            /**
             * burda query yaratsaqda evvelki kimi cetinlik cekmirik neye gore axtardigimzi qeyd edenden sonra tapib capa veririk
             */
            session.beginTransaction();
            List<Student> studentList = (List<Student>) session.createQuery("from Student where firstName='Leman'").list();
            for (Student s:studentList) {
                System.out.println(s);
            }
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
