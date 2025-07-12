package com.user.v1.service.imp;

import com.user.v1.dto.request.UserDto;
import com.user.v1.model.User;
import com.user.v1.repository.UserRepository;
import com.user.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }
}
