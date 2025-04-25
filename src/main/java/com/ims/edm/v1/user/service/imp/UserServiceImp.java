package com.ims.edm.v1.user.service.imp;

import com.ims.edm.v1.user.entity.User;
import com.ims.edm.v1.user.repository.UserRepository;
import com.ims.edm.v1.user.service.UserService;
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
