package com.pet.todo.repository;


import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by Gun on 8/30/18.
 */

public abstract class AbstractRepository<E extends Serializable> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected JpaEntityInformation<E,?> entityInformation;

    protected Class<E> entityClass;


}
