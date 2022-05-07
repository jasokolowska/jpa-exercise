package com.shop;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.shop.TestUtils.*;

public class JpaTest {

    private static final Client client = new Client();
    private static final Basket basket = new Basket();
    private static final Product product = new Product();

    @Test
    public void saveClient(){
        createClient();
        run(entityManager -> {
            Assertions.assertNotNull(entityManager.find(Client.class, client.getId()));
        });

        run(entityManager -> entityManager.persist(client));
    }

    private void createClient() {
        product.setCategory(Category.AGD);
        product.setName("Fridge");
        product.setBasket(basket);
        basket.setClient(client);
        basket.setProducts(List.of(product));
        client.setFirstName("Jan");
        client.setLastName("Kowalska");

        run(entityManager -> entityManager.persist(client));
        run(entityManager -> entityManager.persist(product));
        run(entityManager -> entityManager.persist(basket));
    }


}
