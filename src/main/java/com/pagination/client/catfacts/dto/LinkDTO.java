package com.pagination.client.catfacts.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkDTO {
        private String url;
        private String label;
        private boolean active;
}
