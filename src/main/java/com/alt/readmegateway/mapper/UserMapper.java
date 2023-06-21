package com.alt.readmegateway.mapper;

import com.alt.readmegateway.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface UserMapper {
    public User getByEmail(
            @Param("email") String email
    );
}
