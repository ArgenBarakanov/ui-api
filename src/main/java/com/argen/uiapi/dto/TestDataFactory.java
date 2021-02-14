package com.argen.uiapi.dto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestDataFactory {
    public List<Category> generateCategory() {
       List<Category> categoryList = new ArrayList<>();
       categoryList.add(meal());
       categoryList.add(milk());
       categoryList.add(vegetables());
       categoryList.add(drinks());
       return categoryList;
    }

    private Category meal() {
        Category category = new Category();
        category.setName("Мясо и птица");

        Product product = new Product().setTitle("Говядина").setPrice(500.0);
        Product product1 = new Product().setTitle("Баранина").setPrice(600.0);
        Product product2 = new Product().setTitle("Индейка").setPrice(400.0);
        Product product3 = new Product().setTitle("Курица").setPrice(200.0);
        category.getProducts().add(product);
        category.getProducts().add(product1);
        category.getProducts().add(product2);
        category.getProducts().add(product3);
        return category;
    }

    private Category milk() {
        Category category = new Category();
        category.setName("Молочные продукты");

        Product product = new Product().setTitle("Молоко 2.5%").setPrice(60.0);
        Product product1 = new Product().setTitle("Сыр Тильзит").setPrice(350.0);
        Product product2 = new Product().setTitle("Кефир").setPrice(80.0);
        Product product3 = new Product().setTitle("Сметана").setPrice(85.0);
        category.getProducts().add(product);
        category.getProducts().add(product1);
        category.getProducts().add(product2);
        category.getProducts().add(product3);
        return category;
    }

    private Category vegetables() {
        Category category = new Category();
        category.setName("Овощи");

        Product product = new Product().setTitle("Томат").setPrice(100.0);
        Product product1 = new Product().setTitle("Лук").setPrice(35.0);
        Product product2 = new Product().setTitle("Капуста").setPrice(40.0);
        Product product3 = new Product().setTitle("Болгарский перец").setPrice(85.0);
        category.getProducts().add(product);
        category.getProducts().add(product1);
        category.getProducts().add(product2);
        category.getProducts().add(product3);
        return category;
    }

    private Category drinks() {
        Category category = new Category();
        category.setName("Напитки");

        Product product = new Product().setTitle("Шампанское").setPrice(800.0);
        Product product1 = new Product().setTitle("Пиво").setPrice(250.0);
        Product product2 = new Product().setTitle("Вино").setPrice(1000.0);
        Product product3 = new Product().setTitle("Конъяк").setPrice(1500.0);
        category.getProducts().add(product);
        category.getProducts().add(product1);
        category.getProducts().add(product2);
        category.getProducts().add(product3);
        return category;
    }
}
