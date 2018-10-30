package com.example.login.model;

import java.util.List;

public class GetResponse {

    private List<User> list;

    public GetResponse(List<User> list) {
        this.list = list;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
