package com.alt.readmeuserservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 사용자
 */

@Data
public class User {
    protected Long idx;
    protected String name;
    protected String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;
    protected Character type;
    protected String location;
    protected Long image;
    protected String intro;
}
