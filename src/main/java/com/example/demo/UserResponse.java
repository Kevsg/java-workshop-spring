package com.example.demo;

public class UserResponse {

    private int id;
    private String name;
    private int age;

    public UserResponse(int id, String name) {
        this(id,name,0);
    }

    public UserResponse(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
