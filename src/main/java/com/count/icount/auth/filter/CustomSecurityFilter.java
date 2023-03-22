package com.count.icount.auth.filter;

import com.count.icount.auth.model.authentication.CustomAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomSecurityFilter extends UsernamePasswordAuthenticationFilter {
    private static final String COM_CODE_KEY = "com_code";

    protected String obtainComCode(HttpServletRequest request) {
        return request.getParameter(COM_CODE_KEY);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException {
        CustomAuthentication authRequestInfo = getAuthRequestInfo(request);

        return this.getAuthenticationManager().authenticate(authRequestInfo);
    }

    private CustomAuthentication getAuthRequestInfo(HttpServletRequest request){
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String comCode = obtainComCode(request);

        return new CustomAuthentication(comCode, username, password);
    }



}
