package com.alt.readmeuserservice.service;

import com.alt.readmeuserservice.domain.user.Enterprise;
import com.alt.readmeuserservice.domain.user.School;
import com.alt.readmeuserservice.domain.user.Student;
import com.alt.readmeuserservice.domain.user.User;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
    public User signUpStudent(Student student);
    public User signUpEnterprise(Enterprise enterprise);
    public User signUpSchool(School school);
    public void logout(HttpServletResponse response);
}
