package com.company.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "faculty")
    private String faculty;

    /**
     *  @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     *  @OneToOne(fetch = FetchType.EAGER,
     *
     *  fetch type dediyimiz sey hibernate database den meluatlari lazy yeni ehtiyac oldugu zaman melumatlari cekir
     *  eager ise melumatlari tam cekir deye bilerik,one to one elaqesinde eager olmasi normaldi cunki burda her hansis alist getirmir ve
     *  tebii olaraq databse e de agirliq vermir
     *  amma one to many , many to many elaqelerinde eager olmasi databasein performansini dusurur
     *  meslehet olunan versiya lazy olmasidi
     *  many to one elaqesinde ise default olaraq fetch  eager di cunki list bir obyeke muraciet edir
     *
     *  one to one -  default  eager
     *  one to many - default lazy
     *  many to many - defaul lazy
     *  many to one - default eager
     *
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private List<Subject> subjectList;

    public Student() {
    }

    public Student(String firstName, String lastName, String studentId, String faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.faculty = faculty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
