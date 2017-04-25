package com.teamtreehouse.review;

import com.teamtreehouse.course.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by kpfromer on 4/12/17.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.fineOne(#id)?.reviewer?.username == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviewer?.username == authentication.name")
    void delete(@Param("review") Review entity);
}
