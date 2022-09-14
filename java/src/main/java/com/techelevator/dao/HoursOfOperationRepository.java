package com.techelevator.dao;

import com.techelevator.model.HoursOfOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoursOfOperationRepository extends JpaRepository<HoursOfOperation, Long> {
}