package com.ims.user.v1.service;

import com.ims.user.v1.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);

    User searchUserNameAndEmail(String name, String email);

}
