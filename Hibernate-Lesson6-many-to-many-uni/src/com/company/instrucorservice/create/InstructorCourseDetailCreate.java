package com.company.instrucorservice.create;

import com.company.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class InstructorCourseDetailCreate {

    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).       //  classlari muteq anotated edinki eks teqidrde kodunuz partdiyacaq cunki her yaratdiginiz entity ve elaqeler
                addAnnotatedClass(InstructorDetail.class).  // one to one ve ya digerini yaradanda siz bunu konfiqurasiyaya bildirmeseniz partdilayca1
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try{
            //  tam bir sekilde hem instructor hem course hem detail ve review yaradib save ede bilerik

            Instructor instructor = new Instructor("Elchin","Akbarov","elchin@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("myYoutubeChannel","www.javamirt.com");

            List<Course> courses = new ArrayList<>();
            courses.add(new Course("Hibernate tutorial"));
            courses.add(new Course("Spring tutorial"));
            courses.add(new Course("Java tutorial"));

            List<Review> reviews = new ArrayList<>();
            reviews.add(new Review("Not Bad"));
            reviews.add(new Review("3 star"));
            reviews.add(new Review("greate course"));
            reviews.add(new Review("Awesome"));
            reviews.add(new Review("wonderful"));

            courses.get(0).setReviews(reviews);
            courses.get(1).setReviews(reviews);

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
