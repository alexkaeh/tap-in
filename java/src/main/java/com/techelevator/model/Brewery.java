package com.techelevator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Brewery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "brewery_id", nullable = false)
    private Long breweryId;

//    FIXME How many breweries can a brewer have? How many brewers can a brewery have?
    @OneToOne
    private Users brewer;

    @OneToMany(mappedBy = "brewery")
    List<HoursOfOperation> daysAndHoursOfOperation;

    @Column(name = "brewery_name", nullable = false)
    private String breweryName;

    private String contactInfo;

    private String address;

    private String historyDesc;

    private String breweryImages;

    private boolean isActive;

    public Brewery(Long breweryId, String breweryName, String contactInfo, String address, String historyDesc, String breweryImages, boolean isActive) {
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.contactInfo = contactInfo;
        this.address = address;
        this.historyDesc = historyDesc;
        this.breweryImages = breweryImages;
        this.isActive = isActive;
    }
}
