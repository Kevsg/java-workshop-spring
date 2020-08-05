package com.example.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    @GetMapping("/users")
//    public List<UserResponse> getAllUser() {
//        List<UserResponse> usersResponseList = new ArrayList<>();
//        usersResponseList.add(new UserResponse(1, "User 1"));
//        usersResponseList.add(new UserResponse(2, "User 2"));
//        return usersResponseList;
//    }

    @GetMapping("/users")
    public String getPage(@RequestParam(required = false,defaultValue = "1") String page, @RequestParam(name = "item_per_page",required = false,defaultValue = "10") String itemPerPage) {
        return "Page: " + page + " , itemPerPage: " + itemPerPage;

    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        return new UserResponse(id, "User " + id);
    }




}
