package com.victor.coffee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LatteTest {

    @Test
    public void testLatteName() {
        Latte latte = new Latte();
        assertEquals("Latte", latte.getName());
    }

    @Test
    public void testLattePrice() {
        Latte latte = new Latte();
        assertEquals(5.50, latte.getBasePrice());
    }

    @Test
    public void testLatteIngredients() {
        Latte latte = new Latte();
        assertTrue(latte.getIngredients().contains("Steamed milk with a little foam"));
    }
}
