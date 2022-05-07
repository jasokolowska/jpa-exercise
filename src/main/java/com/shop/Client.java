package com.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Setter
@Getter
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;
}