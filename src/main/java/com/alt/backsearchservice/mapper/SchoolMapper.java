package com.alt.backsearchservice.mapper;

import com.alt.backsearchservice.domain.user.Enterprise;
import com.alt.backsearchservice.domain.user.School;
import com.alt.backsearchservice.domain.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SchoolMapper {
    public School getByEmail(
            @Param("email") String email
    );
    public School getByName(
            @Param("name") String name
    );
}
