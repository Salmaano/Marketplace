package com.example.Marketplace.config;

import org.springframework.http.HttpStatus;

public class DuplicateFoundException extends  RuntimeException {
    private Object data = null;

    private HttpStatus status = null;

    public DuplicateFoundException(){
        super();
    }


    public DuplicateFoundException(String message){
        super(message);
    }

    public DuplicateFoundException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public DuplicateFoundException(
            HttpStatus status,
            String message,
            Object data
    ) {
        this(
                status,
                message
        );
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
