package com.teamtreehouse.course.core;

import javax.persistence.*;

/**
 * Created by kpfromer on 4/12/17.
 */

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    @Version
    private Long version;

    protected BaseEntity() {
        id = null;
    }

}
