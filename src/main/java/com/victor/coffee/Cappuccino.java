package com.victor.coffee;

public class Cappuccino extends Coffee{

    public Cappuccino() {
        super("Cappuccino", 5.80);
        super.addIngredients("Espresso shot");
        super.addIngredients("Steamed milk and a thick layer of foam");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a Cappuccino...");
        System.out.println("Pulling an espresso shot");
        System.out.println("Steaming milk");
        System.out.println("Topping with foam");
    }
}
