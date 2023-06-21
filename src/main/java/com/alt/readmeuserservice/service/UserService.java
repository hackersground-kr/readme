package com.alt.readmeuserservice.service;

import com.alt.readmeuserservice.domain.user.User;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    public User signUp(User user);
    public void logout(HttpServletResponse response);
}
