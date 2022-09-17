package com.techelevator.service;

import com.techelevator.dao.BreweryRepository;
import com.techelevator.dao.UserRepository;
import com.techelevator.model.Brewery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
// @Transactional
@AllArgsConstructor
public class BreweryService {

    @Autowired
    private final BreweryRepository breweryRepo;
    @Autowired
    private final UserRepository userRepo;

    public List<Brewery> getAllBreweries() {
        return breweryRepo.findAll();
    }

    public Brewery getBreweryByCurrentUser() {
        Long userId = userRepo.findByUsername("bob").getId();
        return breweryRepo.findByUserId(userId).orElseThrow();
    }

    public Brewery getBreweryById(Long id) {
        return breweryRepo.findById(id).orElseThrow();
    }

    public void updateBreweryInfo(Long id, Brewery updatedBrewery) {
        updatedBrewery.setBreweryId(id);
        breweryRepo.saveAndFlush(updatedBrewery);
    }

    public List<Brewery> getOrphanBreweries() {
        return breweryRepo.findByUserIdIsNull();
    }
}
