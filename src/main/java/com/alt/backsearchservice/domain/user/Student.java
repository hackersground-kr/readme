package com.alt.backsearchservice.domain.user;

import lombok.Data;

@Data
public class Student extends User {
    private String birth;
    private Byte grade;
}
