package com.ims.edm.v1.user.service;

import com.ims.edm.v1.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);

    User searchUserNameAndEmail(String name, String email);

}
