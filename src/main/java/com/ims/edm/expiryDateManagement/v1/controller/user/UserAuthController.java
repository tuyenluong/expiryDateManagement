package com.ims.edm.expiryDateManagement.v1.controller.user;

import com.ims.edm.expiryDateManagement.v1.entity.User;
import com.ims.edm.expiryDateManagement.v1.service.UserService;
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
