package com.count.icount.model.Dto;

import com.count.icount.model.Enums.HttpStatus;
import lombok.*;

@Getter
@Setter
public class Response<T> {
    private Integer statusCode;
    private String httpMessage;
    private String errorMessage;
    private String callBack;
    private T data;

    public Response(HttpStatus httpStatus, T data){
        this.statusCode = httpStatus.getStatusCode();
        this.httpMessage = httpStatus.getHttpMessage();
        this.data = data;
        this.errorMessage = null;
    }



}
