package com.techelevator.model;

import com.techelevator.enumerated.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    @SequenceGenerator(name = "review_seq")
    @Column(name = "review_id", nullable = false)
    private Long reviewId;

    @ManyToOne // defaults to eager fetch
    @JoinColumn(name = "beer_id")
    private Beer beer;

    @ManyToOne // defaults to eager fetch
    @JoinColumn(name = "user_id")
    private Users user;

    private Rating rating;

    private String reviewText;

}