package com.alt.readsearchservice.mapper;

import com.alt.readsearchservice.domain.user.Student;
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
    public void updateSuggestion(
            @Param("idx") Long idx
    );
}
