package com.user.v1.service;

import com.user.v1.dto.request.UserDto;
import com.user.v1.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);

    User searchUserNameAndEmail(String name, String email);

    List<UserDto> getAllUsers();

}
