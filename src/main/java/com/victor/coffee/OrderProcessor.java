package com.victor.coffee;

public class OrderProcessor {

    public void process(Order order) {
        System.out.println("Preparing your order...");
        for (Coffee coffee : order.getItems()) {
            coffee.prepare();
        }
        System.out.println(order);
    }
}
