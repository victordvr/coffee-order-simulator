package com.victor.coffee;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Coffee> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addCoffee(Coffee coffee) {
        items.add(coffee);
    }

    public List<Coffee> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Coffee::getBasePrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Summary:\n");
        for (Coffee coffee : items) {
            sb.append("- ").append(coffee.toString()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calculateTotalPrice()));
        return sb.toString();
    }
}
