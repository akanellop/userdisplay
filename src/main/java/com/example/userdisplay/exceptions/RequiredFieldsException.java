package com.example.userdisplay.exceptions;

public class RequiredFieldsException extends RuntimeException {
    public RequiredFieldsException(Throwable err){
        super("Not all required fields were filled.");
    }
}
