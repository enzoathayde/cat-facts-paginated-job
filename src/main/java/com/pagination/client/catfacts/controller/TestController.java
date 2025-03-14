package com.pagination.client.catfacts.controller;

import com.pagination.client.catfacts.dto.CatFactsDTO;
import com.pagination.client.catfacts.service.FactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TestController {

    @Autowired
    private FactsService factsService;

    @GetMapping("/test")
    public CatFactsDTO testing() {
        return factsService.fetchCatFacts();
    }

}
