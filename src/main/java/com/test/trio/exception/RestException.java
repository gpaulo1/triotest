package com.test.trio.exception;

public class RestException extends RuntimeException{

    private String message;
    private Integer status;
    private String statusText;

    public RestException(final String message, final Throwable throwable, final Integer status){
        super(throwable);
        this.message = message;
        this.status = status;
    }

}
