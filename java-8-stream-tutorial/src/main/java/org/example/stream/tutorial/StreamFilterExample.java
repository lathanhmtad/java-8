package org.example.stream.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private int id;
    private String name;
    private float price;

    public Product() {}

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class StreamFilterExample {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        for (Product product: getProducts()
             ) {
            if(product.getPrice() > 3000f) {
                list.add(product);
            }
        }
        for (Product p: list
             ) {
            System.out.println(p);
        }

        System.out.println("*****************************");

        // using stream API
        List<Product> list2 = getProducts().stream()
                .filter(p -> p.getPrice() > 3000f)
                .collect(Collectors.toList());
        list2.forEach(System.out::println);
    }

    private static List<Product> getProducts() {
        List<Product> listOfProduct = new ArrayList<>();
        listOfProduct.add(new Product(1, "HP Laptop", 2500f));
        listOfProduct.add(new Product(2, "Dell Laptop", 3510f));
        listOfProduct.add(new Product(3, "Lenovo Laptop", 3000f));
        listOfProduct.add(new Product(4, "Sony Laptop", 2000f));
        listOfProduct.add(new Product(5, "Apple Laptop", 9000f));

        return listOfProduct;
    }
}
