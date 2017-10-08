package com.kuzniarski.exceptions;

/**
 * Created by Kacper Kuźniarski on 23.06.2017.
 */
public class NoRegexException extends Exception {
    public NoRegexException() {
    }

    public NoRegexException(String message) {
        super(message);
    }

    public NoRegexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRegexException(Throwable cause) {
        super(cause);
    }

    public NoRegexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
