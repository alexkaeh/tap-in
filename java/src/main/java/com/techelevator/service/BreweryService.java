package com.techelevator.service;

import com.techelevator.dao.BreweryRepository;
import com.techelevator.model.Brewery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
@AllArgsConstructor
public class BreweryService {

    @Autowired
    private final BreweryRepository breweryRepo;

    public List<Brewery> getAllBreweries() {
        return breweryRepo.findAll();
    }
}
