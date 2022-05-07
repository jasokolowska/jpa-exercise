package com.shop;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Producer {

    @GeneratedValue
    @Id
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "producer")
    private List<Product> products;

}
