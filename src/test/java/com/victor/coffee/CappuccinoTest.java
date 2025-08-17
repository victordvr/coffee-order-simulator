package com.victor.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CappuccinoTest {

    @Test
    public void testCappuccinoName() {
        Cappuccino cappuccino = new Cappuccino();
        assertEquals("Cappuccino", cappuccino.getName());
    }

    @Test
    public void testCappuccinoPrice() {
        Cappuccino cappuccino = new Cappuccino();
        assertEquals(5.80, cappuccino.getBasePrice());
    }

    @Test
    public void testCappuccinoIngredients() {
        Cappuccino cappuccino = new Cappuccino();
        assertTrue(cappuccino.getIngredients().contains("Steamed milk and a thick layer of foam"));
    }
}
