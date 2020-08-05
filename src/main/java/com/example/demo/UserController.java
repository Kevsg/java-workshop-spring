package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public PagingResponse getPage(@RequestParam(defaultValue = "1") int page, @RequestParam(name = "item_per_page", defaultValue = "10") int itemPerPage) {
        PagingResponse pagingResponse = new PagingResponse(page, itemPerPage);
        List<UserResponse> usersResponseList = new ArrayList<>();
        Page<User> result = userRepository.findAll(PageRequest.of(page-1, itemPerPage));
        for(User u: result.getContent()) {
            usersResponseList.add(new UserResponse(u.getId(),u.getName(), u.getAge()));
        }
        pagingResponse.setUsersResponseList(usersResponseList);
        return pagingResponse;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        return new UserResponse(user.get().getId(), user.get().getName(), user.get().getAge());
    }

    @PostMapping("/users")
    public UserResponse createNewUser(@RequestBody NewUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user = userRepository.save(user);
        return new UserResponse(user.getId(),user.getName()+user.getAge(), user.getAge());
    }

}
