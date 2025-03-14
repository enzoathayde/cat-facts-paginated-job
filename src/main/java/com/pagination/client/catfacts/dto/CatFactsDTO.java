package com.pagination.client.catfacts.dto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CatFactsDTO {

    private int currentPage;
    private List<FactDTO> data;
    private String firstPageUrl;
    private int from;
    private int lastPage;
    private String lastPageUrl;
    private List<LinkDTO> links;
    private String nextPageUrl;
    private String path;
    private int perPage;
    private String prevPageUrl;
    private int to;
    private int total;

}
