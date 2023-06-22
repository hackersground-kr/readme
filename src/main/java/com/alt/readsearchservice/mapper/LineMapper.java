package com.alt.readsearchservice.mapper;

import com.alt.readsearchservice.domain.Line;
import com.alt.readsearchservice.domain.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LineMapper {
    public Line getByName(
            @Param("name") String name
    );
}
