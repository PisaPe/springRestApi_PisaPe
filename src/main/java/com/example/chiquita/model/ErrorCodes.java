package com.example.chiquita.model;

public enum ErrorCodes {
    INVALID_FIRST_NAME("INVALID_FIRST_NAME"),
    UNAUTHORIZED("UNAUTHORIZED"),
    BAD_BODY("BAD_BODY");
    private final String value;
    private ErrorCodes(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
