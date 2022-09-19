package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findByBreweryId(Long breweryId);

}