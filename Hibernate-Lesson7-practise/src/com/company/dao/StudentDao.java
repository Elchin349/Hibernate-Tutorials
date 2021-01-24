package com.company.dao;

import com.company.entity.Address;
import com.company.entity.Student;
import com.company.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDao {

    public void saveStudent(Student student) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Subject.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("SAVED");
        } finally {
            sessionFactory.close();
        }
    }

    public Student findStudentByStudentId(String studentId) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Subject.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        List<Student> studentList = null;
        try {
            session.beginTransaction();

            /**
             * burda bizim Student imizde Subject list olaraq var ve biz database den melumati cekende Student ve Address melumatlarini
             * getirsede Listi yeni Subject Listi getirende bir defe normal isdiyende novbeti defe exception atir
             *
             * Unable to evaluate the expression Method threw 'org.hibernate.LazyInitializationException' exception.
             *
             * ve bu exception ona goredirki diger melumatlari getirib liste catanda artiq session close olunur yeni catdirmir
             * bunu fix etmeyin bir nece usulu vardir
             * en cox internetde goreceyiniz usul oneToMany de fetch = FetchType.EAGER usulunu goreceksiz
             * bu problemi hell etsede yaxsi usul deyil
             * cunki databasi yuklemis olursuz ona gore bunun default olaraq Lazy qalmasi daha meqsede uygundur
             * bunun ucun yaxsi versiyalardan birisi Left Join Fetch den istifade ederek problemsiz hell etmekdir
             *
             * Basqa versiylarda var tebiiki NamedEntityGraph anotasiyasi ilede bu isi gore bilersiz
             */
            Query query = session.createQuery("select s from Student s LEFT JOIN FETCH s.subjectList where s.studentId = '" + studentId + "'", Student.class);
            studentList = query.getResultList();
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
        return studentList!=null ? studentList.stream().findFirst().get() : null;
    }

    public List<Student> findAll() {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Subject.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            List studentList = session.createQuery("select s from Student s LEFT JOIN FETCH s.subjectList").list();
            session.getTransaction().commit();

            return studentList;
        } finally {
            sessionFactory.close();
        }
    }
}
