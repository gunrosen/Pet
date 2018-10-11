package com.pet.todo.repository;


import com.pet.todo.domain.Domain;
import com.pet.todo.support.db.SpecificationUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

/**
 * Created by Gun on 8/30/18.
 */

public abstract class AbstractRepository<DOMAIN extends Domain, ID> implements InitializingBean {

    @PersistenceContext
    protected EntityManager entityManager;

    protected JpaEntityInformation<DOMAIN, ?> entityInformation;

    protected Class<DOMAIN> entityClass;

    public AbstractRepository(Class<DOMAIN> className) {
        this.entityClass = className;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(entityClass, entityManager);
    }

    public DOMAIN getById(ID id, String idFieldName) {
        TypedQuery<DOMAIN> mainQuery = initQuery(SpecificationUtils.equal(idFieldName, id), null, null);
        return mainQuery.getSingleResult();
    }

    public List<DOMAIN> getAll(Specification<DOMAIN> spec, Pageable pageable, Sort sort) {
        TypedQuery<DOMAIN> mainQuery = initQuery(spec, pageable, sort);
        return mainQuery.getResultList();
    }


    private void save(DOMAIN domain) {
        Assert.notNull(domain, "Domain can not be null");
        if (entityInformation.isNew(domain)) {
            entityManager.persist(domain);
        } else {
            domain = entityManager.merge(domain);
        }
    }


    /************************************************/
    /**************** PRIVATE METHODS ***************/
    /************************************************/

    protected final TypedQuery<DOMAIN> initQuery(Specification<DOMAIN> spec,
                                                 Pageable pageable, Sort sort) {

//        Specification<DOMAIN> mainSpecs = SpecificationUtils.and(clientFilterSpec, activeSpec, draftSpec,
//                getDefaultCriteria(), spec);

        if (pageable != null) {
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
            }
            return getQuery(spec, pageable);
        }

        return getQuery(spec, sort);
    }

    protected TypedQuery<DOMAIN> getQuery(Specification<DOMAIN> spec, Pageable pageable) {

        Sort sort = pageable == null ? null : pageable.getSort();
        return getQuery(spec, sort);
    }

    protected TypedQuery<DOMAIN> getQuery(Specification<DOMAIN> spec, Sort sort) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DOMAIN> query = builder.createQuery(entityClass);

        Root<DOMAIN> root = applySpecificationToCriteria(spec, query);
        query.select(root);

        if (sort != null) {
            query.orderBy(toOrders(sort, root, builder));
        }

        return entityManager.createQuery(query);
    }

    private <S> Root<DOMAIN> applySpecificationToCriteria(Specification<DOMAIN> spec, CriteriaQuery<S> query) {

        Assert.notNull(query);
        Root<DOMAIN> root = query.from(entityClass);

        if (spec == null) {
            return root;
        }

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        Predicate predicate = spec.toPredicate(root, query, builder);

        if (predicate != null) {
            query.where(predicate);
        }

        return root;
    }
}
