package com.user.v1.service;

import com.user.v1.dto.request.LoginRequestDto;

public interface AuthService {

    String login(LoginRequestDto req);
}
