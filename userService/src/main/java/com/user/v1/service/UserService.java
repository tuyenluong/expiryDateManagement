package com.user.v1.service;

import com.user.v1.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);

    User searchUserNameAndEmail(String name, String email);

}
