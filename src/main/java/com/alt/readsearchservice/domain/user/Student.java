package com.alt.readsearchservice.domain.user;

import lombok.Data;

@Data
public class Student extends User {
    private Long belong;
    private String belongName;
    private String birth;
    private Byte grade;
}
