package com.count.icount.model.dto;

import com.count.icount.model.enums.HttpStatus;
import lombok.*;

@Getter
@Setter
public class Response<T> {
    private Integer statusCode;
    private String httpMessage;
    private String errorMessage;
    private T data;

    public Response(HttpStatus httpStatus, T data){
        this.statusCode = httpStatus.getStatusCode();
        this.httpMessage = httpStatus.getHttpMessage();
        this.data = data;
        this.errorMessage = null;
    }

    public Response(T data){
        this.statusCode = HttpStatus.OK.getStatusCode();
        this.httpMessage = HttpStatus.OK.getHttpMessage();
        this.data = data;
        this.errorMessage = null;
    }



}
