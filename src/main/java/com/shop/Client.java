package com.shop;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;

}
