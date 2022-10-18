package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "may tinh","Hanoi"));
        products.put(2, new Product(2, "Bill",  "Danang"));
        products.put(3, new Product(3, "Alex", "Saigon"));
        products.put(4, new Product(4, "Adam",  "Beijin"));
        products.put(5, new Product(5, "Sophia", "Miami"));
        products.put(6, new Product(6, "Rose", "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = findAll();
        for (Product p : products2) {
            if (p.getName().contains(name)){
                products1.add(p);
            }
        }
        return products1;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
