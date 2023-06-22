package com.alt.readsearchservice.mapper;

import com.alt.readsearchservice.domain.user.Enterprise;
import com.alt.readsearchservice.domain.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurposeMapper {
    public List<Enterprise> getByStudentIdx(
            @Param("idx") Long idx
    );
    public List<Student> getByEnterpriseIdx(
            @Param("idx") Long idx
    );
}
