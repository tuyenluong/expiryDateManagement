package com.ims.edm.expiryDateManagement.v1.service;

import com.ims.edm.expiryDateManagement.v1.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);

    User searchUserNameAndEmail(String name, String email);

}
