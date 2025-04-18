package com.recipin.reciping_app.dto.filter;

import java.util.List;

public class FilterDefinition {

    private List<FilterEntry> filterEntries;
    private String filterOrderBy;
    private Enum<FilterOrderDir> filterOrderDir;
    private Integer limit;
    private Integer pageNumber;


    public FilterDefinition(List<FilterEntry> filterEntries, String filterOrderBy, Enum<FilterOrderDir> filterOrderDir, Integer limit, Integer pageNumber) {
        this.filterEntries = filterEntries;
        this.filterOrderBy = filterOrderBy;
        this.filterOrderDir = filterOrderDir;
        this.limit = limit;
        this.pageNumber = pageNumber;
    }

    public List<FilterEntry> getFilterEntries() {
        return filterEntries;
    }

    public void setFilterEntries(List<FilterEntry> filterEntries) {
        this.filterEntries = filterEntries;
    }

    public String getFilterOrderBy() {
        return filterOrderBy;
    }

    public void setFilterOrderBy(String filterOrderBy) {
        this.filterOrderBy = filterOrderBy;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Enum<FilterOrderDir> getFilterOrderDir() {
        return filterOrderDir;
    }

    public void setFilterOrderDir(Enum<FilterOrderDir> filterOrderDir) {
        this.filterOrderDir = filterOrderDir;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
