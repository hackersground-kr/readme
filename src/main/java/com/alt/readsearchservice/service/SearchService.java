package com.alt.readsearchservice.service;

import com.alt.readsearchservice.domain.user.Enterprise;
import com.alt.readsearchservice.domain.user.School;
import com.alt.readsearchservice.domain.user.Student;
import com.alt.readsearchservice.domain.user.User;
import com.alt.readsearchservice.mapper.EnterpriseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchService {
    public Student getStudentByEmail(String email);
    public List<Student> getStudentByName(String name);

    public School getSchoolByEmail(String email);
    public List<School> getSchoolByName(String name);

    public Enterprise getEnterpriseByEmail(String email);
    public List<Enterprise> getEnterpriseByName(String name);
    public List<Enterprise> getPurposeByStudent(String email);
    public List<Student> getPurposeByEnterprise(String email);
    public void updateSuggestion(Long idx);
}
