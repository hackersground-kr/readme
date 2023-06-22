package com.alt.readmeuserservice.domain.user;

import lombok.Data;

@Data
public class School extends User {
    private Character schoolType;
    private Integer student;
    private Integer satisfaction;
}
