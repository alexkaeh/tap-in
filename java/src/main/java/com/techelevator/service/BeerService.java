package com.techelevator.service;

import com.techelevator.dao.BeerRepository;
import com.techelevator.dao.BreweryRepository;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BeerService {

    @Autowired
    private final BeerRepository beerRepo;
    @Autowired
    private final BreweryRepository breweryRepo;
    @Autowired // Necessary to autowire?
    private final UserDao userDao;

    public List<Beer> getAllBeers() {
        return beerRepo.findAll();
    }

    public List<Beer> getBeersByBrewer(Principal principal) {
        // Optional<Brewery> userBrewery = breweryRepo.findById(principal);
        // return currentUser.getBrewery().getBeers();

        // get current user id
        // get brewery that matches user id
        // get all beers that match brewery id
        return null;
    }

    public Optional<Beer> getBeerById(Long id) {
        return beerRepo.findById(id);
    }

    public Beer addBeer(Beer newBeer) {
        beerRepo.add(newBeer);
        return newBeer;
    }
}
