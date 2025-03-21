package com.exceptions.lab.customExceptions;

public class NoCoffeeException extends Exception {
    public NoCoffeeException() {
        super("Coffee not enough");
    }
}
