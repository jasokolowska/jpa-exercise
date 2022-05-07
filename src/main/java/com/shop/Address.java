package com.shop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipCode;

}
