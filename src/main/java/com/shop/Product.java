package com.shop;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Product {

    @GeneratedValue
    @Id
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "producer_id")
    private Producer producer;

}
