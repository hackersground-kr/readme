package com.alt.readmeuserservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 사용자
 */

@Data
public class User {
    private Long idx;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Character type;
    private String location;
    private Long image;
    private String intro;
}
