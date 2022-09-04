package com.techelevator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hours_of_operation")
public class HoursOfOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hours_of_operation_seq")
    @SequenceGenerator(name = "hours_of_operation_seq")
    @Column(name = "hoo_id", nullable = false)
    private Long hooId;

    @ManyToOne // default fetch eager
    @JoinColumn(name = "brewery_id")
    private Brewery brewery;

    private Day day;

    @Column(name ="open_time", columnDefinition = "TIME")
    private LocalTime openTime;

    @Column(name ="close_time", columnDefinition = "TIME")
    private LocalTime closeTime;

    public HoursOfOperation(Long hooId, Brewery brewery, Day day, LocalTime openTime, LocalTime closeTime) {
        this.hooId = hooId;
        this.brewery = brewery;
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
}