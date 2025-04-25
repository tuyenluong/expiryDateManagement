package com.ims.edm.v1.user.controller;

import com.ims.edm.v1.user.entity.User;
import com.ims.edm.v1.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/search")
    public User searchUser(@RequestParam String name, @RequestParam String email){
        return userService.searchUserNameAndEmail(name,email);
    }


}
