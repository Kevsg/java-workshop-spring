package com.example.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public UserResponse[] getAllUser() {
        UserResponse[] usersResponses = new UserResponse[2];
        usersResponses[0] = new UserResponse(1,"Kevin");
        usersResponses[1] = new UserResponse(2,"John");
        return usersResponses;
    }
}
