package com.ims.edm.expiryDateManagement.v1.service.imp;

import com.ims.edm.expiryDateManagement.v1.entity.User;
import com.ims.edm.expiryDateManagement.v1.repository.UserRepository;
import com.ims.edm.expiryDateManagement.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User searchUserNameAndEmail(String name, String email) {
        return userRepository.findByNameAndEmail(name,email);
    }
}
