package com.example.userdisplay.exceptions;

public class ExistingEmailException extends RuntimeException {
    public ExistingEmailException(Throwable err){
        super("Email already exists.",err);
    }
}

