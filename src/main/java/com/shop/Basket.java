package com.shop;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "basket")
@NoArgsConstructor
@Setter
@Getter
public class Basket {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "basket")
    private List<Product> products;

    @OneToOne(mappedBy = "basket")
    private Client client;

}