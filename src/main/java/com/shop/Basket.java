package com.shop;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Basket {

    @Id
    @GeneratedValue
    private UUID id;
    @JoinTable(name = "basket_products", joinColumns = @JoinColumn(name = "basket_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

}



