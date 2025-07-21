package com.victor.coffee;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, Coffee> options;

    public Menu() {
        options = new HashMap<>();
        options.put(1, new Espresso());
        options.put(2, new Latte());
        options.put(3, new Cappuccino());
    }

    public void display() {
        System.out.println("******** MENU ********");
        for (Map.Entry<Integer, Coffee> entry : options.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().toString());
        }
        System.out.println("8. See current order");
        System.out.println("9. See orders history");
        System.out.println("0. Finish and exit");
        System.out.println("Select an option: ");
    }

    public Coffee select(int option) throws InvalidOrderException {
        if (!options.containsKey(option)) {
            throw new InvalidOrderException("Invalid selection.");
        }
        return options.get(option);
    }
}
