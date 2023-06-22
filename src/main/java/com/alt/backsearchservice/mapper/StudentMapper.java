package com.alt.backsearchservice.mapper;

import com.alt.backsearchservice.domain.user.Enterprise;
import com.alt.backsearchservice.domain.user.School;
import com.alt.backsearchservice.domain.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    public Student getByEmail(
            @Param("email") String email
    );
    public List<Student> getByName(
            @Param("name") String name
    );
}
