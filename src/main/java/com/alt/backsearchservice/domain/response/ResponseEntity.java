package com.alt.backsearchservice.domain.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ResponseEntity {
    protected Integer status;
    protected Object data;
}