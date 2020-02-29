package com.rasa.rest.simpleshopbyspring.exceptionHandler;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message){super(message);}
}
