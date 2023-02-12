package com.count.icount.exception;

import com.count.icount.model.Enums.CustomError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException{
    private CustomError customError;

    public String getErrorMessage(){
        return this.customError.getErrorMessage();
    }

    public int getStatusCode(){
        return this.customError.getStatusCode();
    }

}
