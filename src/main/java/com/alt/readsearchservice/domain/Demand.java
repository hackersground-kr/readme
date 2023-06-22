package com.alt.readsearchservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Demand {
    private Long idx;
    private Long EnterpriseIdx;
    private Long lineIdx;
}
