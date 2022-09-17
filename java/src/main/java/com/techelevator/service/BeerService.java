package com.techelevator.service;

import com.techelevator.dao.BeerRepository;
import com.techelevator.dao.BreweryRepository;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserRepository;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class BeerService {

    @Autowired
    private final BeerRepository beerRepo;
    @Autowired
    private final BreweryRepository breweryRepo;
    @Autowired // Necessary to autowire?
    private final UserDao userDao;
    @Autowired
    private final UserRepository userRepo;

    public List<Beer> getBeersByBrewer(Principal principal) {
        User currentUser = userDao.findByUsername(principal.getName());
        // Brewery myBrewery = breweryRepo.f
        // List<Beer> myBeers = beerRepo.findAllByUser(currentUser);
        // return currentUser.getBrewery().getBeers();

        // get current user id
        // get brewery that matches user id
        // get all beers that match brewery id
        return null;
    }

    public List<Beer> getAllBeers() {
        return beerRepo.findAll();
    }

}
