package com.pet.todo.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Gun on 8/30/18.
 */
@NoRepositoryBean
public class BaseRepository<T, ID extends Serializable> extends SimpleJpaRepository <T,ID> implements Repository<T, ID> {

    public BaseRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
