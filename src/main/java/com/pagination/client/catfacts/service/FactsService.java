package com.pagination.client.catfacts.service;

import com.pagination.client.catfacts.dto.CatFactsDTO;
import com.pagination.client.catfacts.entity.Facts;
import com.pagination.client.catfacts.repository.FactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FactsService {

    private final String url = "https://catfact.ninja/";
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private FactsRepository factsRepository;

    public CatFactsDTO fetchCatFacts() {

        var page = 1;
        var pageSize = 10;
        var mountedUrl = url + "facts?limit=" + pageSize + "&page=" + page;
        CatFactsDTO response = restTemplate.getForObject(mountedUrl, CatFactsDTO.class);
        var totalPages = response.getTotal() / 10;

        if(!response.getData().isEmpty()) {
            do {
                response.getData().stream().forEach(facts -> {
                    Facts factsForDatabsase = new Facts();
                    factsForDatabsase.setFact(facts.getFact());
                    factsForDatabsase.setLengthValue(facts.getFactLength());
                    var existingFact = factsRepository.factExistsInDatabase(facts.getFact());
                    if (existingFact.isEmpty()) {
                        factsRepository.save(factsForDatabsase);
                    } else {
                        System.out.println("Found a fact already existent in our database....");
                    }
                });

            page++;
            mountedUrl = url + "facts?limit=" + pageSize + "&page=" + page;
            response = restTemplate.getForObject(mountedUrl, CatFactsDTO.class);

            } while (page <= totalPages);
        }

        return response;

    }


}
