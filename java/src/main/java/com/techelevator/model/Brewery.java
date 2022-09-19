/**
 * Represents each individual brewery.
 * <p>
 * Only one brewer is permitted per brewery
 */

package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "brewery_id", nullable = false)
    private Long breweryId;

    // no actual field in database due to one-to-many relationship
    @OneToMany(mappedBy = "brewery")
    List<HoursOfOperation> daysAndHoursOfOperation;

    @Column(name = "brewery_name", nullable = false)
    private String breweryName;

    // Non owning side
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @Transient
    @OneToMany(mappedBy = "brewery")
    List<Beer> beers;

    private String contactInfo;
    private String address;
    private String historyDesc;
    private String breweryImages;
    private boolean isActive;
}
