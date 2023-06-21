package com.alt.readmeuserservice.domain.user;

import lombok.Data;

@Data
public class Enterprise extends User {
    private Long income;
    private Byte grade;
}
