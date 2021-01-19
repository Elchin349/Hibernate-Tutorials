package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "website")
    private String website;

    /**
     * Bu sefer ise artiq 2 terefli yeni bi directional elaqe qurmus olduq ve cascade ile hansi funskiyalari ede biler onlari qeyd edirik
     */
    @OneToOne(mappedBy = "instructorDetail",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    })
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String website) {
        this.youtubeChannel = youtubeChannel;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" + "\n" +
                "id=" + id + "\n" +
                ", youtubeChannel='" + youtubeChannel + "\n" +
                ", website='" + website + "\n" +
                '}';
    }
}
