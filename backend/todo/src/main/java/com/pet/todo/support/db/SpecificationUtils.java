package com.pet.todo.support.db;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gun on 10/11/18.
 */
public class SpecificationUtils {
    @SafeVarargs
    public static <D> Specification<D> and(Specification<D>... specs) {
        if (specs == null || specs.length == 0) {
            return null;
        }

        final List<Specification<D>> validSpecs = new ArrayList<>(specs.length);

        for (Specification<D> spec : specs) {
            if (spec != null) {
                validSpecs.add(spec);
            }
        }

        if (validSpecs.isEmpty()) {
            return null;
        } else if (validSpecs.size() == 1) {
            return validSpecs.get(0);
        } else {
            Specification<D> combinedSpecs = new Specification<D>() {

                @Override
                public Predicate toPredicate(Root<D> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    int size = validSpecs.size();
                    Predicate[] predicates = new Predicate[size];

                    for (int i = 0; i < size; i++) {
                        predicates[i] = validSpecs.get(i).toPredicate(root, query, cb);
                    }

                    return cb.and(predicates);
                }

            };

            return combinedSpecs;
        }
    }

    @SafeVarargs
    public static <D> Specification<D> or(Specification<D>... specs) {
        if (specs == null || specs.length == 0) {
            return null;
        }

        final List<Specification<D>> validSpecs = new ArrayList<>(specs.length);

        for (Specification<D> spec : specs) {
            if (spec != null) {
                validSpecs.add(spec);
            }
        }

        if (validSpecs.isEmpty()) {
            return null;
        } else if (validSpecs.size() == 1) {
            return validSpecs.get(0);
        } else {
            Specification<D> combinedSpecs = new Specification<D>() {

                @Override
                public Predicate toPredicate(Root<D> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    int size = validSpecs.size();
                    Predicate[] predicates = new Predicate[size];

                    for (int i = 0; i < size; i++) {
                        predicates[i] = validSpecs.get(i).toPredicate(root, query, cb);
                    }

                    return cb.or(predicates);
                }

            };

            return combinedSpecs;
        }
    }

    public static <D> Specification<D> equal(final String field, final Object value) {

        return new Specification<D>() {
            @Override
            public Predicate toPredicate(Root<D> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.<String>get(field), value);
            }
        };
    }

    public static <D> Specification<D> notEqual(final String field, final Object value) {

        return new Specification<D>() {
            @Override
            public Predicate toPredicate(Root<D> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.notEqual(root.<String>get(field), value);
            }
        };
    }

    public static <D> Specification<D> in(final String field, final Collection<? extends Object> values) {

        return new Specification<D>() {
            @Override
            public Predicate toPredicate(Root<D> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.in(root.<String>get(field)).in(values);
            }
        };
    }

    public static <D> Specification<D> like(final String field, String searchText) {
        if (StringUtils.isEmpty(searchText)) {
            return null;
        }

        final String searchPattern = StringUtils.getSqlSearchLikePattern(StringUtils.getSearchableString(searchText));
        return new Specification<D>() {

            @Override
            public Predicate toPredicate(Root<D> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.<String>get(field), searchPattern);
            }
        };
    }

}
