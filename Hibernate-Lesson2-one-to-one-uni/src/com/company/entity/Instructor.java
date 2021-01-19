package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    /**
     * 2 class arasinda elaqe qurmaq isteyirem ve bunu sql terefde ozum yazmiram onun yerine oneToOne annotasiyasi ile
     * 2 table arasinda elaqe qururam
     * one to one yeni 1 e 1 elaqe , bu o anlama gelirki bir isntruktorun bir dene detailsi ola biler
     * ve ya absqa bir misal getirek bir insanin bir sexsiyyet vesiqesi ola biler , ona gorede elaqeni bu sekilde qururuq
     * ve bunlari join ede bilek deye JoinColumn annotasiyasi ile yazmis oldugumuz "instructor_detail_id" adi ile cagiririq
     * bu sekilde qurulan elaqe bizi o avantajlari verirki
     * sen Instructoru cagiranda instructor detailda onunle birlikde gelmis olur ve sen buna gore uzun bir innerjoin query si yazmaq mecburiyyetinde dyeilsen
     * butun bu meseleni jpa hell edir
     * Bes cascadetype ALl nedir:
     * Cascading da deyilir bu o anlama gelriki misal Instructorun etdiyi islemleri tetbiqleri  InstructorDetail ede bilmeyecek, cunki ilk novbede biz
     * InstructorDetailda one to one etmemisik yalniz unique bir elaqe yaratmisiq ve CascadeType All deyende bu o anlama gelirki
     * Instrutor  deteailsin uzerinde update delete ve saire kimi butun islemleri gore biler , misal detailsda siz deye bielrsizki refresh ede bilsin ancaq
     * detailsdan insrtuctoru poza bilmesin bu kimi islemleri Cascade ile gorurler
     * Cascade tiplero:
     *
     * PERSIST	- eger esas table ve ya parent obyekt deyekki saxlanilirsa save olunursa , onunla birlikde diger ona bagli olan obyektlerde save olunacaq
     * MERGE    - esas table ve ya parent obyekt birlesdirrise diger child obyektlerde merge olunacaq cunki aslidi ondan
     * DETACH   - esas parent obyekt ayrilmissa (объект отсоединен) ona bagli olan diger obyektlerde ayrilmis olacaq
     * REFRESH  - esas parent obyekt yenilenerse refresh olunarsa ona bagli olan diger obyektlerde yenilenecek
     * REMOVE   - parent silinerse elaqeli diger obyektde silinecek
     * ALL      - ve yuxaridaki butum emeliyyatlarin hamsini etmek isteyirsnese ALl secirsen
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
