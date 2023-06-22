package com.alt.readsearchservice.mapper;

import com.alt.readsearchservice.domain.Demand;
import com.alt.readsearchservice.domain.Line;
import com.alt.readsearchservice.domain.Purpose;
import com.alt.readsearchservice.domain.user.Enterprise;
import com.alt.readsearchservice.domain.user.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemandMapper {
    public void register(
            Demand demand
    );
    public List<Enterprise> getByLine(
            @Param("line") Long line
    );
}
