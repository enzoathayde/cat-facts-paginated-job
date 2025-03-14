package com.pagination.client.catfacts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Label;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FactDTO {

    private String fact;
    @JsonProperty("length")
    private Integer factLength;

}
