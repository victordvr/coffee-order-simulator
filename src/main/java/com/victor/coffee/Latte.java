package com.victor.coffee;

public class Latte extends Coffee{

    public Latte() {
        super("Latte", 5.50);
        super.addIngredients("Espresso shot");
        super.addIngredients("Steamed milk with a little foam");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a Latte...");
        System.out.println("Pulling an espresso shot");
        System.out.println("Steaming milk");
        System.out.println("Adding a little foam");
    }
}
