package com.victor.coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Coffee {
    private String name;
    private double basePrice;
    private List<String> ingredients;

    public Coffee() {}

    public Coffee(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public List<String> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    protected void addIngredients(String ingredient) {
        ingredients.add(ingredient);
    }

    public abstract void prepare();

    @Override
    public String toString() {
        return name + " $" + basePrice + " | Ingredients: " + String.join(", ", ingredients);
    }
}
