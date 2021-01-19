package com.company.studentservice;

import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentService {

    public static void main(String[] args){
        // SessionFactory ile database e connection qururuq, hansi fayldan cekeceyimiz faylin adini yazaraq bildirirk,hansi entity ile
      //  is goreceyimizi add edirik ve sonda factory ini yaradiriq
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        // Sessiyasini yaradiriq bayaq yuxaridaki qurdugumuz current sessiyani
        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Create Student");

            // sessiyani basladiriq
            session.beginTransaction();
            Student student = new Student();
            student.setFirstName("Leman");
            student.setLastName("Huseynova");
            student.setFinCode("tr85r3");
            // save edirik
            session.save(student);

            // commit edib bitirik
            session.getTransaction().commit();

            System.out.println("SAVED");
        }finally {
            // ve en sonda ne olursa olsun close edirik
            sessionFactory.close();
        }
    }
}
