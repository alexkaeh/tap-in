package com.techelevator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "beer")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
    @SequenceGenerator(name = "beer_seq")
    @Column(name = "beer_id", nullable = false)
    private Long beerId;

    @ManyToOne() // fixme
    @JoinColumn()
    private Brewery brewery;

    @OneToMany(mappedBy = "beer")
    private List<Review> reviews = new java.util.ArrayList<>();

    private String beerName;
    private String description;
    private String image;
    private double abv;
    private BeerType beerType;
    private boolean isActive;
}