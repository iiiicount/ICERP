package com.count.icount.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDto implements Serializable {

    private boolean login;
    private String error;
    private String errorMessage;


}


