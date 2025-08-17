package com.victor.coffee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EspressoTest {

    @Test
    public void testEspressoName() {
        Espresso espresso = new Espresso();
        assertEquals("Espresso", espresso.getName());
    }

    @Test
    public void testEspressoPrice() {
        Espresso espresso = new Espresso();
        assertEquals(3.0, espresso.getBasePrice());
    }

    @Test
    public void testEspressoIngredients() {
        Espresso espresso = new Espresso();
        assertTrue(espresso.getIngredients().contains("Espresso shot"));
    }
}
