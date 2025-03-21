package com.exceptions.lab;

import com.exceptions.lab.customExceptions.BadFeedbackException;
import com.exceptions.lab.customExceptions.NoCoffeeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeShopTest {
    private CoffeeShopClass coffeeShop;
    private CoffeeShopClass emptyCoffeeShop;

    @BeforeEach
    void setUp() {
        coffeeShop = new CoffeeShopClass(2);
        emptyCoffeeShop = new CoffeeShopClass(0);
    }

    @Test
    void buyCoffee() throws Exception {
        coffeeShop.buyCoffee();
        assertEquals(1, coffeeShop.coffeeAmount());

        Exception exception = assertThrows(NoCoffeeException.class, () -> emptyCoffeeShop.buyCoffee());
        assertEquals("Coffee not enough", exception.getMessage());
    }

    @Test
    void buyCoffeeIfPresent() {
        assertTrue(coffeeShop.buyCoffeeIfPresent());
        assertEquals(1, coffeeShop.coffeeAmount());
        assertFalse(emptyCoffeeShop.buyCoffeeIfPresent());
        assertEquals(0, emptyCoffeeShop.coffeeAmount());
    }

    @Test
    void giveFeedback() throws RuntimeException {
        coffeeShop.giveFeedback("Bellissimo!!");
        assertEquals("Bellissimo!!", coffeeShop.readFeedbacks().getFirst());
        assertEquals(1, coffeeShop.readFeedbacks().size());

        Exception exception = assertThrows(BadFeedbackException.class, () -> coffeeShop.giveFeedback(""));
        assertEquals("Feedback was not saved.", exception.getMessage());

        assertThrows(BadFeedbackException.class, () -> coffeeShop.giveFeedback(" "));
        assertThrows(BadFeedbackException.class, () -> coffeeShop.giveFeedback("bad"));
        assertThrows(BadFeedbackException.class, () -> coffeeShop.giveFeedback("not so bad"));
        assertThrows(BadFeedbackException.class, () -> emptyCoffeeShop.giveFeedback("worst"));
        assertThrows(BadFeedbackException.class, () -> emptyCoffeeShop.giveFeedback("not tasty"));
        assertThrows(BadFeedbackException.class, () -> emptyCoffeeShop.giveFeedback("not drinkable"));
    }

    @Test
    void readFeedbacks() {
        assertEquals(0, coffeeShop.readFeedbacks().size());
        coffeeShop.giveFeedback("Tasty coffee!");
        coffeeShop.giveFeedback("Loved it!");
        assertEquals(2, coffeeShop.readFeedbacks().size());
    }

    @Test
    void coffeeAmount()  throws Exception {
        assertEquals(2, coffeeShop.coffeeAmount());
        coffeeShop.buyCoffee();
        assertEquals(1, coffeeShop.coffeeAmount());
    }
}