package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JoinColumn(name = "brewery_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Brewery breweryId;

    @OneToMany(mappedBy = "beer")
    private List<Review> reviews = new java.util.ArrayList<>();

    private String beerName;
    @Column(columnDefinition = "varchar (2048)")
    private String description;
    private String image;
    private double abv;
    @Enumerated(EnumType.STRING)
    @Column(name = "beer_type")
    private BeerType beerType;
    private boolean isActive;
}