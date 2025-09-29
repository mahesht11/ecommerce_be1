package com.ecom.app.exception;

public class ProductIdException extends RuntimeException{

    private String message;
    public ProductIdException(String message){
        super(message);
    }
}
