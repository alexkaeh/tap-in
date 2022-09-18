package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    Optional<Brewery> findByUserId(Long userId);

    List<Brewery> findByUserIdIsNull();
}
