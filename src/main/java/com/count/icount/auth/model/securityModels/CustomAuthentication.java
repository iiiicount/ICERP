package com.count.icount.auth.model.securityModels;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class CustomAuthentication extends UsernamePasswordAuthenticationToken{
    private String comCode;

    public CustomAuthentication(String comCode, Object principal, Object credentials){
        super(principal, credentials);
        this.comCode = comCode;
    }


}

