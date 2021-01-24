package com.company.entity;

import javax.persistence.*;
import java.util.List;

//  bir entity obyekti yaratdiq
@Entity  //  bu classin database ile elaqeli oldugunu gosteren bir Annotation dir
@Table(name = "students")  //  table in adi ne olacaq onu qeyd edirik eger yazmasaq default ozu goturecek
public class Student {

    @Id  // table daki id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ve generasiya olunan id her defesinde ozu artacaq
    private Long id;
    @Column(name = "first_name")  // columnlar ise table daki stunlari gosterir ve adlarini bu sekilde istediyim kimi qoya bilersem, eger qoymasan variable adini default goturecek
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "fin_code")
    private String finCode;

    /**
     * Join table jer iki obyektin deyeri ayri tableda saxliyir
     * yeni foreing keyleri olmadan bu leaqeni qurur
     * eger bele bir elaqe lazimdisa joinTbale dan istifade olunur
     * eger performans lazimdirsa o zaman joincolumn dan istifade edin
     * cunki extra bir table yaratmaga ehtiyaci olmur
     * Adeten Join Table i daha cox many to many one to many elqelerinden
     * istifade edirler ancaq diger elqelerdede bunu yazmaq mumkundur
     *
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, String finCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.finCode = finCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", finCode='" + finCode + '\'' +
                ", courses=" + courses +
                '}';
    }
}
