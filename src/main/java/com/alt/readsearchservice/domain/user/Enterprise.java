package com.alt.readsearchservice.domain.user;

import lombok.Data;

@Data
public class Enterprise extends User {
    private Long income;
    private Integer employee;
}