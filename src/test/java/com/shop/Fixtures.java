package com.shop;

import java.util.UUID;

class Fixtures {

    private static final String CURRENCY_CODE = "PLN";

    static String uuid() {
        return UUID.randomUUID().toString();
    }

    static Client testClient() {
        var client = new Client();
        client.setFirstName("Jan");
        client.setLastName("Kowalski");
        var address = new Address();
        address.setZipCode("11111");
        address.setCity("Kraków");
        address.setStreet("Mariacka 1");
        client.setAddress(address);
        return client;
    }

    static Basket testBasket() {
        return new Basket();
    }

    static Product testProduct() {
        var product = new Product();
        product.setName("Fridge");
        product.setCategory(Category.AGD);
        product.setPrice(2799.00);
        return product;
    }

    static Product testProduct2() {
        var product = new Product();
        product.setName("Laptop");
        product.setCategory(Category.COMPUTERS);
        product.setPrice(5399.00);
        return product;
    }

    static Producer testProducer() {
        var producer = new Producer();
        producer.setName("Dell");
        return producer;
    }

    static Producer testProducer2() {
        var producer = new Producer();
        producer.setName("Samsung");
        return producer;
    }


}
