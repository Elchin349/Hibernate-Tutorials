package com.company.instrucorservice.create;

import com.company.entity.Course;
import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CourseAndInstructorCreate {

    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).  // <---     3cu classida elave edirikki uzerinde meliyyatlar apara bilek
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try{
            /**
             *Instructor , detail,ve course yaradacayiq ve hamsini save edeceyik
             * ve databse i acib baxsaz goreceksizki 3 course 1 ide  baglanib ve instructoru cagiranda ona aid olan
             * nece dene course varsa hamsi gelecek
             */
            Instructor instructor = new Instructor("Elchin","Akbarov","elchin@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("myYoutubeChannel","www.javamirt.com");

            List<Course> courses = new ArrayList<>();
            courses.add(new Course("Hibernate tutorial"));
            courses.add(new Course("Spring tutorial"));
            courses.add(new Course("Java tutorial"));

            instructor.setInstructorDetail(instructorDetail);
            instructor.setCourses(courses);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("SAVED");
        }finally {

            sessionFactory.close();
        }
    }
}
