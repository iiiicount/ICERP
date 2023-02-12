package com.count.icount.exception;

import com.count.icount.model.Dto.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public Response<Void> customExceptionHandler(CustomException customException){
        // todo
        return null;
    }
}
