package com.pet.todo.repository;


import com.pet.todo.domain.Domain;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by Gun on 8/30/18.
 */

public abstract class AbstractRepository<DOMAIN extends Domain> implements InitializingBean {

    @PersistenceContext
    protected EntityManager entityManager;

    protected JpaEntityInformation<DOMAIN, ?> entityInformation;

    protected Class<DOMAIN> entityClass;

    public AbstractRepository(Class<DOMAIN> className) {
        this.entityClass = className;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(entityClass,entityManager);
    }


    private void save(DOMAIN domain){
        Assert.notNull(domain,"Domain can not be null");
        if(entityInformation.isNew(domain)){
            entityManager.persist(domain);
        }else {
            domain = entityManager.merge(domain);
        }
    }


    /************************************************/
    /**************** PRIVATE METHODS ***************/
    /************************************************/


}
