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

public class InstructorCreate {

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

            Instructor instructor = new Instructor("Fuad","Rehmanov","fuad@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("myYoutubeChannel","www.javamirt.com");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("SAVED");
        }finally {

            sessionFactory.close();
        }
    }
}
