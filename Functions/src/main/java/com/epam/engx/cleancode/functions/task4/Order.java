package com.epam.engx.cleancode.functions.task4;

import com.epam.engx.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.Iterator;
import java.util.List;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {
        double orderPrice = 0.0;
        removeUnavailableProducts();
        return getOrderPrice(orderPrice);
    }

    private double getOrderPrice(double orderPrice) {
        for (Product p : products)
            orderPrice += p.getProductPrice();
        return orderPrice;
    }

    private void removeUnavailableProducts() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (!p.isAvailable())
                iterator.remove();
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
