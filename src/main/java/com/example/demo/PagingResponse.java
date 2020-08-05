package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PagingResponse {
    @JsonProperty("users")
    private List<UserResponse> usersResponseList;
    @JsonProperty("page_no")
    private int page;
    @JsonProperty("item_per_page")
    private int itemPerPage;

    public PagingResponse(int page, int itemPerPage) {
        this.page = page;
        this.itemPerPage = itemPerPage;
    }

    public List<UserResponse> getUsersResponseList() {
        return usersResponseList;
    }

    public void setUsersResponseList(List<UserResponse> usersResponseList) {
        this.usersResponseList = usersResponseList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(int itemPerPage) {
        this.itemPerPage = itemPerPage;
    }


}
