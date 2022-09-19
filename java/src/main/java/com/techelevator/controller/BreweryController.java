package com.techelevator.controller;

import com.techelevator.model.Brewery;
import com.techelevator.service.BreweryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @PostMapping("/{id}")
    public ResponseEntity<Brewery> createNewBrewery(@PathVariable Long id, @RequestBody Brewery newBrewery) {
        // TODO Does POST need an id path variable?
        newBrewery.setBreweryId(id);
        return new ResponseEntity<>(breweryService.createNewBrewery(newBrewery), HttpStatus.CREATED);
    }

    @GetMapping("/my")
    public Brewery getBreweryByCurrentUser() {
        return breweryService.getBreweryByCurrentUser();
    }

    @GetMapping("/{id}")
    public Brewery getBreweryById(@PathVariable Long id) {
        return breweryService.getBreweryById(id);
    }

    @PutMapping("/{id}")
    public void updateBreweryInfo(@PathVariable Long id, @RequestBody Brewery updatedBrewery) {
        breweryService.updateBreweryInfo(id, updatedBrewery);
    }

    @GetMapping("/unassigned")
    public List<Brewery> getOrphanBreweries() {
        return breweryService.getOrphanBreweries();
    }


}
