package com.techelevator.controller;

import com.techelevator.model.Beer;
import com.techelevator.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/beer")
@CrossOrigin
public class BeerController {

    @Autowired
    private final BeerService beerService;

    @GetMapping("")
    public List<Beer> getBeersByBrewer(Principal principal) {
        return beerService.getBeersByBrewer(principal);
    }

}
