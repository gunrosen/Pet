package com.pet.todo.repository.impl;

import com.pet.todo.domain.Customer;
import com.pet.todo.repository.custom.CustomerCustomizedRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Gun on 9/4/18.
 */
@Repository
public class CustomerCustomizedRepositoryImpl implements CustomerCustomizedRepository {

    @PersistenceContext
    private EntityManager em;

    private JpaEntityInformation<Customer, ?> entityInformation;

    @PostConstruct
    public void postConstruct(){
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(Customer.class,em);
    }

    @Override
    public List<Customer> getCustomerManagedBy(int employeeId) {
//        TypedQuery<Customer> query = em.createQuery("select c from customers c " +
//                "where c.salesRepEmployeeNumber = :employeeId",Customer.class);
//        return  query.setParameter("employeeId",employeeId).getResultList();
        return null;
    }


}
