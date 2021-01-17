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

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
