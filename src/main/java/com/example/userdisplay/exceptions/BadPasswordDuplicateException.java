package com.example.userdisplay.exceptions;

public class BadPasswordDuplicateException extends RuntimeException {
    public BadPasswordDuplicateException(Throwable err){
        super("Given passwords don't match.",err);

    }
}
