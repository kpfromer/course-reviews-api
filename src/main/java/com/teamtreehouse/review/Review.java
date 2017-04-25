package com.teamtreehouse.review;

import com.teamtreehouse.course.Course;
import com.teamtreehouse.course.core.BaseEntity;
import com.teamtreehouse.user.User;

import javax.persistence.*;

/**
 * Created by kpfromer on 4/12/17.
 */

@Entity
public class Review extends BaseEntity {
    private int rating;
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviewer;

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this();
        this.rating = rating;
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
