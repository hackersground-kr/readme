package com.alt.readsearchservice.service.impl;

import com.alt.readsearchservice.domain.user.Enterprise;
import com.alt.readsearchservice.domain.user.School;
import com.alt.readsearchservice.domain.user.Student;
import com.alt.readsearchservice.mapper.EnterpriseMapper;
import com.alt.readsearchservice.mapper.SchoolMapper;
import com.alt.readsearchservice.mapper.StudentMapper;
import com.alt.readsearchservice.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final StudentMapper studentMapper;
    private final SchoolMapper schoolMapper;
    private final EnterpriseMapper enterpriseMapper;
    @Override
    public Student getStudentByEmail(String email) {
        Student student = studentMapper.getByEmail(email);
        student.setBelongName(schoolMapper.get(student.getBelong()).getName());
        return student;
    }
    @Override
    public List<Student> getStudentByName(String name) {
        List<Student> students = studentMapper.getByName(name);
        for (Student student : students) {
            student.setBelongName(schoolMapper.get(student.getBelong()).getName());
        }
        return studentMapper.getByName(name);
    }
    @Override
    public School getSchoolByEmail(String email) {
        School school = schoolMapper.getByEmail(email);
        school.setStudent(schoolMapper.getStudentCount(school.getIdx()));

        return school;
    }
    @Override
    public List<School> getSchoolByName(String name) {
        return schoolMapper.getByName(name);
    }

    @Override
    public Enterprise getEnterpriseByEmail(String email) {
        return enterpriseMapper.getByEmail(email);
    }

    @Override
    public List<Enterprise> getEnterpriseByName(String name) {
        return enterpriseMapper.getByName(name);
    }
    @Override
    public void updateSuggestion(Long idx) {
        studentMapper.updateSuggestion(idx);
    }
}
