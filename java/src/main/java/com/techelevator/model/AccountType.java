package com.techelevator.model;

import org.springframework.beans.factory.annotation.Autowired;

public enum AccountType {
    ADMIN,
    BREWMASTER,
    BEER_LOVER;

    @Autowired
    AccountType() {}
}
