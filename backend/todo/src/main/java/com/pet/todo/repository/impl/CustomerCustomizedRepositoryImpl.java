package com.pet.todo.repository.impl;

import com.pet.todo.domain.Customer;
import com.pet.todo.repository.custom.CustomerCustomizedRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;


import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Gun on 9/4/18.
 */
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
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.where()
        Specification<Customer> specification = (root1, query, criteriaBuilder) -> {

        };

        TypedQuery<Customer> typedQuery = criteriaQuery.
        return typedQuery.getResultList();
    }


}
