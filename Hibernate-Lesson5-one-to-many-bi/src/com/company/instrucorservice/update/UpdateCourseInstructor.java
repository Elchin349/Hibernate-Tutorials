package com.company.instrucorservice.update;

import com.company.entity.Course;
import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import com.company.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UpdateCourseInstructor {

    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try{

            session.beginTransaction();

            //  ya query yazib bu sekilde deye bilerikki bazadan 4 den 6 a kimi olan coruse lari bir instructora baglamaq isteyirem
            //  ya daki id i e gor etek tek tapib ele sets ede bilersiz
            //  4 den 6 a kimi olmasi sert deyil sadece menim yaratdigim yeni kurlsar 4 5 6 d aolduguna gore bele secim etdim
            List<Course> courses = session.createQuery("from com.company.entity.Course where id >= 4 and id <= 6").getResultList();

            long id = 2L;
            Instructor instructor = session.get(Instructor.class,id);
            instructor.setCourses(courses);


            session.getTransaction().commit();

            System.out.println("DONE");
        }finally {

            sessionFactory.close();
        }
    }
}
