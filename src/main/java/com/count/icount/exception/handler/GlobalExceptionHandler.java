package com.count.icount.exception.handler;

import com.count.icount.exception.CExceptionExample;
import com.count.icount.exception.CProductException;
import com.count.icount.exception.CSellDetailNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice //모든 컨트롤러에서 발생하는 exception 처리
public class GlobalExceptionHandler {
    @ExceptionHandler(CExceptionExample.class)
    public ResponseEntity<ErrorResponse> handleCExceptionExample(CExceptionExample ex){
        log.error("handleCExceptionExample", ex);
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(CProductException.class)
    public ResponseEntity<ErrorResponse> handleCProductException(CProductException ex) {
        log.error("handleCProductException", ex);
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler({CSellDetailNotFoundException.class})
    public ResponseEntity<ErrorResponse> NotFountException(Exception e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.valueOf(response.getStatus()))
                .body(response);
    }
}
