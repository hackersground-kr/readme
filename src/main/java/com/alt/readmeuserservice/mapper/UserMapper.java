package com.alt.readmeuserservice.mapper;

import com.alt.readmeuserservice.domain.user.Enterprise;
import com.alt.readmeuserservice.domain.user.School;
import com.alt.readmeuserservice.domain.user.Student;
import com.alt.readmeuserservice.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User getByEmail(
            @Param("email") String email
    );
    public void register(
            User user
    );
    public void registerStudent(
            Student student
    );
    public void registerSchool(
            School school
    );
    public void registerEnterprise(
            Enterprise enterprise
    );
}
