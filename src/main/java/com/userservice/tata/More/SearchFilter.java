package com.userservice.tata.More;

public class SearchFilter {
    private String searchKey;
    private String searchValue;
    private SearchFilterEnum searchFilterEnum;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public SearchFilterEnum getSearchFilterEnum() {
        return searchFilterEnum;
    }

    public void setSearchFilterEnum(SearchFilterEnum searchFilterEnum) {
        this.searchFilterEnum = searchFilterEnum;
    }
}
