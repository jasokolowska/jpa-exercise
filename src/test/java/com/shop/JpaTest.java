package com.shop;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.shop.TestUtils.ENTITY_MANAGER_FACTORY;
import static com.shop.TestUtils.run;

public class JpaTest {

    private final Client client = Fixtures.testClient();
    private final Producer producer = Fixtures.testProducer();
    private final Producer producer2 = Fixtures.testProducer();
    private final Basket basket = Fixtures.testBasket();
    private final Product product = Fixtures.testProduct();
    private final Product product2 = Fixtures.testProduct2();

    @AfterAll
    static void afterAll() {
        ENTITY_MANAGER_FACTORY.close();
    }

    @BeforeEach
    void beforeEach() {
        product.setProducer(producer2);
        product2.setProducer(producer);
        basket.setProducts(List.of(product, product2));
        basket.setClient(client);
    }

    @Test
    public void saveProduct() {
        createProduct();
        run(entityManager -> {
            Assertions.assertNotNull(entityManager.find(Product.class, product.getId()));
        });
    }

    private void createProduct() {
        run(entityManager -> {
            entityManager.persist(producer);
            entityManager.persist(product);
        });
    }

    @Test
    public void saveBasket() {
        createBasket();
        run(entityManager -> {
            Assertions.assertNotNull(entityManager.find(Basket.class, basket.getId()));
        });
    }

    @Test
    public void saveClient() {
        run(entityManager -> entityManager.persist(client));
        run(entityManager -> {
            Assertions.assertNotNull(entityManager.find(Client.class, client.getId()));
        });
    }

    @Test
    public void saveProducer() {
        run(entityManager -> entityManager.persist(producer));
        run(entityManager -> {
            Assertions.assertNotNull(entityManager.find(Producer.class, producer.getId()));
        });
    }

    private void createBasket() {
        run(entityManager -> entityManager.persist(product));
        run(entityManager -> entityManager.persist(product2));
        run(entityManager -> entityManager.persist(client));
        run(entityManager -> entityManager.persist(basket));
    }

}
