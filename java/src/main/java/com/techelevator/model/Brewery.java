/**
 * Represents each individual brewery.
 * <p>
 * Only one brewer is permitted per brewery
 */

package com.techelevator.model;

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

    // @OneToOne(mappedBy = "brewery")
    // private User brewer;

    // no actual field in database due to one-to-many relationship
    @OneToMany(mappedBy = "brewery")
    List<HoursOfOperation> daysAndHoursOfOperation;

    @Column(name = "brewery_name", nullable = false)
    private String breweryName;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "users_brewery", joinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
//            @JoinColumn(name = "brewery_id", referencedColumnName = "brewery_id")})
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    // @OneToMany(mappedBy = "brewery")
    // List<Beer> beers;

    private String contactInfo;
    private String address;
    private String historyDesc;
    private String breweryImages;
    private boolean isActive;
}
