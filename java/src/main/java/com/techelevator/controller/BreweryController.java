package com.techelevator.controller;

import com.techelevator.model.Brewery;
import com.techelevator.service.BreweryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/brewery")
public class BreweryController {

    @Autowired
    private final BreweryService breweryService;

    @GetMapping("")
    public List<Brewery> getAllBreweries() {
        return breweryService.getAllBreweries();
    }

}
