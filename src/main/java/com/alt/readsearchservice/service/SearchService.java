package com.alt.readsearchservice.service;

import com.alt.readsearchservice.domain.user.School;
import com.alt.readsearchservice.domain.user.Student;

import java.util.List;

public interface SearchService {
    public Student getStudentByEmail(String email);
    public List<Student> getStudentByName(String name);

    public School getSchoolByEmail(String email);
    public List<School> getSchoolByName(String name);
}
