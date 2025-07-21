package com.victor.coffee;

public class Espresso extends Coffee{

    public Espresso() {
        super("Espresso", 3.0);
        super.addIngredients("Espresso shot");
    }

    @Override
    public void prepare() {
        System.out.println("Pulling a single shot of espresso...");
    }
}
