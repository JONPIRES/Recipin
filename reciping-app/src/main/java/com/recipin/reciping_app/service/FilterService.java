package com.recipin.reciping_app.service;

import com.recipin.reciping_app.dto.filter.FilterDefinition;
import com.recipin.reciping_app.model.BaseEntity;

import java.util.List;

public interface FilterService {

    <T extends BaseEntity> List<T> getFilteredList(FilterDefinition filterDefinition, Class<T> entityClass);

}
