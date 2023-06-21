package com.alt.readmeuserservice.domain.user;

import lombok.Data;

@Data
public class School extends User {
    private Character type;
    private Integer student;
    private Integer satisfaction;
}
