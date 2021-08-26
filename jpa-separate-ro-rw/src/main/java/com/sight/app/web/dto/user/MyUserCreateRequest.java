package com.sight.app.web.dto.user;

public class MyUserCreateRequest {

    private String name;
    private String state;

    public MyUserCreateRequest() {}

    public MyUserCreateRequest(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
