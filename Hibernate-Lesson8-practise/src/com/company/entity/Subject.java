package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_of_lesson")
    private String nameOfLesson;
    @Column(name = "teacher_of_lesson")
    private String teacherOfLesson;
    @Column(name = "total_lesson_hours")
    private int totalLessonHours;

    public Subject() {
    }

    public Subject(String nameOfLesson, String teacherOfLesson, int totalLessonHours) {
        this.nameOfLesson = nameOfLesson;
        this.teacherOfLesson = teacherOfLesson;
        this.totalLessonHours = totalLessonHours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfLesson() {
        return nameOfLesson;
    }

    public void setNameOfLesson(String nameOfLesson) {
        this.nameOfLesson = nameOfLesson;
    }

    public String getTeacherOfLesson() {
        return teacherOfLesson;
    }

    public void setTeacherOfLesson(String teacherOfLesson) {
        this.teacherOfLesson = teacherOfLesson;
    }

    public int getTotalLessonHours() {
        return totalLessonHours;
    }

    public void setTotalLessonHours(int totalLessonHours) {
        this.totalLessonHours = totalLessonHours;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", nameOfLesson='" + nameOfLesson + '\'' +
                ", teacherOfLesson='" + teacherOfLesson + '\'' +
                ", totalLessonHours=" + totalLessonHours +
                '}';
    }
}
