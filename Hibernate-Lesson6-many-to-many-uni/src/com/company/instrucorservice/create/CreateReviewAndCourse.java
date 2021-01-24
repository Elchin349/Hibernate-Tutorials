package com.company.instrucorservice.create;

import com.company.entity.Course;
import com.company.entity.Instructor;
import com.company.entity.InstructorDetail;
import com.company.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateReviewAndCourse {

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
            /**
             * Hal hazirda biz bi course ve review lar yaratdiq ancaq indi bu obyektin instructoru yoxdu
             * elimizde olan bu obyekti nece set ede bilerikki instructoru da olsun diger class da baxacayiq
             * UpdateCourseInstructor deye bir class yaradacam
             */
            Course course = new Course(".NET tutorial");

            List<Review> reviews = new ArrayList<>();
            reviews.add(new Review("Not Bad"));
            reviews.add(new Review("3 star"));
            reviews.add(new Review("greate course"));
            reviews.add(new Review("Awesome"));
            reviews.add(new Review("wonderful"));

            course.setReviews(reviews);

            session.beginTransaction();

            session.save(course);

            session.getTransaction().commit();

            System.out.println("SAVED");
        }finally {

            sessionFactory.close();
        }
    }
}
