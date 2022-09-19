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
    @Autowired
    private final UserRepository userRepo;

    public List<Beer> getBeersByBrewer(String username) {
        Long userId = userDao.findByUsername(username).getId();
        Long breweryId = breweryRepo.findByUserId(userId).orElseThrow().getBreweryId();
        return beerRepo.findByBreweryId(breweryId);
    }

    public List<Beer> getAllBeers() {
        return beerRepo.findAll();
    }

}
