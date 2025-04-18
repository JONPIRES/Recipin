package com.recipin.reciping_app.dto.filter;

public class FilterEntry {

    private String filterBy;
    private FilterMatch filterMatch;
    private String filterValue;
    private FilterJoin filterJoin;

    public FilterEntry() {

    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public FilterMatch getFilterMatch() {
        return filterMatch;
    }

    public void setFilterMatch(FilterMatch filterMatch) {
        this.filterMatch = filterMatch;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public FilterJoin getFilterJoin() {
        return filterJoin;
    }

    public void setFilterJoin(FilterJoin filterJoin) {
        this.filterJoin = filterJoin;
    }
}
