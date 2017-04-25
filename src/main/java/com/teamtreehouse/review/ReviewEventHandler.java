package com.teamtreehouse.review;

import com.teamtreehouse.user.User;
import com.teamtreehouse.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by kpfromer on 4/25/17.
 */

@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {

    private final UserRepository users;

    @Autowired
    public ReviewEventHandler(UserRepository users) {
        this.users = users;
    }


    @HandleBeforeCreate
    public void addReviewBasedOnLoggedInUser(Review review){
        //gets logged in user
        //it throws null pointer exception if no user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        review.setReviewer(user);
    }
}
