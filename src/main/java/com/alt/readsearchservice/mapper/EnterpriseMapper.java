package com.alt.readsearchservice.mapper;

import com.alt.readsearchservice.domain.user.Enterprise;
import com.alt.readsearchservice.domain.user.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    public Enterprise getByEmail(
            @Param("email") String email
    );
    public List<Enterprise> getByName(
            @Param("name") String name
    );
}
