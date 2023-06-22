package com.alt.readsearchservice.mapper;

import com.alt.readsearchservice.domain.user.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchoolMapper {
    public School get(
            @Param("idx") Long idx
    );
    public School getByEmail(
            @Param("email") String email
    );
    public List<School> getByName(
            @Param("name") String name
    );
}
