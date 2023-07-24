package com.count.icount.auth.model.securitymodels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class ICountAuthentication extends UsernamePasswordAuthenticationToken{
    private String comCode;

    public ICountAuthentication(String comCode, Object principal, Object credentials){
        super(principal, credentials);
        this.comCode = comCode;
    }


}

