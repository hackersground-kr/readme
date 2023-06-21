package com.alt.readmeuserservice.mapper;

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
}
