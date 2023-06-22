package com.alt.readmeuserservice.service;

import com.alt.readmeuserservice.domain.request.TokenInfo;
import com.alt.readmeuserservice.domain.user.*;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    public User signUpStudent(Student student);
    public User signUpEnterprise(Enterprise enterprise);
    public User signUpSchool(School school);
    public TokenInfo login(LoginRequest request);
    public void logout(HttpServletResponse response);
}
