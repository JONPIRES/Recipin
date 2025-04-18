package com.recipin.reciping_app.service.impl;

import com.recipin.reciping_app.dto.filter.*;
import com.recipin.reciping_app.model.BaseEntity;
import com.recipin.reciping_app.service.FilterService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <T extends BaseEntity> List<T> getFilteredList(FilterDefinition filterDefinition, Class<T> entityClass) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityClass);
        Root<T> root = query.from(entityClass);

        Predicate finalPredicate = null;
        FilterOrderDir filterOrder;

        // Building predicates based on filter entries
        for (FilterEntry entry : filterDefinition.getFilterEntries()) {
            String field = entry.getFilterBy();
            String value = entry.getFilterValue();
            FilterMatch match = entry.getFilterMatch();
            FilterJoin join = entry.getFilterJoin(); // IS = AND, OR = OR

            Predicate predicate = switch (match) {
                case EQUALS -> cb.equal(root.get(field), value);
                case NOT_EQUALS -> cb.notEqual(root.get(field), value);
                case CONTAINS -> cb.like(root.get(field), "%" + value + "%");
                case STARTS_WITH -> cb.like(root.get(field), value + "%");
                case GREATER_THAN -> cb.greaterThan(root.get(field), value);
                case LESS_THAN -> cb.lessThan(root.get(field), value);
                case IS_NULL -> cb.isNull(root.get(field));
                case IS_NOT_NULL -> cb.isNotNull(root.get(field));
            };

            // Combining the predicates using AND/OR
            if (finalPredicate == null) {
                finalPredicate = predicate;
            } else {
                finalPredicate = switch (join) {
                    case IS -> cb.and(finalPredicate, predicate); // IS = AND
                    case OR -> cb.or(finalPredicate, predicate);  // OR = OR
                };
            }
        }

        // Apply the final predicate to the query
        if (finalPredicate != null) {
            query.where(finalPredicate);
        }

        // Handle ordering
        if (filterDefinition.getFilterOrderBy() != null && filterDefinition.getFilterOrderDir() != null) {
            Path<Object> orderPath = root.get(filterDefinition.getFilterOrderBy());
            if (filterDefinition.getFilterOrderDir() == FilterOrderDir.ASC) {
                query.orderBy(cb.asc(orderPath));
            } else {
                query.orderBy(cb.desc(orderPath));
            }
        }

        // Pagination logic
        int pageNumber = (filterDefinition.getPageNumber() != null) ? filterDefinition.getPageNumber() : 1;  // Default to page 1
        int limit = (filterDefinition.getLimit() != null) ? filterDefinition.getLimit() : 10;  // Default to 10 items per page

        int offset = (pageNumber - 1) * limit;  // Calculate the offset based on the page number

        // Apply pagination and execute the query
        return entityManager.createQuery(query)
                .setFirstResult(offset)  // Set the offset for pagination
                .setMaxResults(limit)  // Set the limit (page size)
                .getResultList();
    }
}
