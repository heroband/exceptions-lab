package com.exceptions.lab.customExceptions;

public class BadFeedbackException extends RuntimeException {
    public BadFeedbackException() {
        super("Feedback was not saved.");
    }
}
