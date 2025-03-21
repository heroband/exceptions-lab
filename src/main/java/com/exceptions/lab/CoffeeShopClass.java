package com.exceptions.lab;

import com.exceptions.lab.customExceptions.BadFeedbackException;
import com.exceptions.lab.customExceptions.NoCoffeeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeShopClass implements CoffeeShop {
    private int _coffeeAmount;
    private List<String> _feedbacks;
    private final static List<String> BadWords = Arrays.asList("bad", "worst", "not tasty", "not drinkable");

    public CoffeeShopClass(int coffeeAmount) {
        _coffeeAmount = coffeeAmount;
        _feedbacks = new ArrayList<>();
    }

    @Override
    public void buyCoffee() throws Exception {
        if (_coffeeAmount <= 0) {
            throw new NoCoffeeException();
        }
        _coffeeAmount--;
    }

    @Override
    public boolean buyCoffeeIfPresent() {
        if (_coffeeAmount > 0) {
            _coffeeAmount--;
            return true;
        }
        System.out.println("Have no more coffee :(");
        return false;
    }

    @Override
    public void giveFeedback(String feedback) throws RuntimeException {
        if (feedback.isBlank() || containsBadWords(feedback)) {
            throw new BadFeedbackException();
        }
        _feedbacks.add(feedback);
        System.out.println("Feedback saved!");
    }

    private boolean containsBadWords(String feedback) {
        var lowercaseFeedback = feedback.toLowerCase();

        for (String badWord : BadWords) {
            if (lowercaseFeedback.contains(badWord)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> readFeedbacks() {
        return _feedbacks;
    }

    @Override
    public int coffeeAmount() {
        return _coffeeAmount;
    }
}
