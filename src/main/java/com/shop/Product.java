package com.shop;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Product {

    @GeneratedValue
    @Id
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "basket_ID")
    private Basket basket;
}
