package com.alt.backsearchservice.domain.user;

import lombok.Data;

@Data
public class School extends User {
    private Character school_type;
    private Integer student;
    private Integer satisfaction;
}
