package com.count.icount.auth.filter;

import com.count.icount.auth.model.securityModels.CustomAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomSecurityFilter extends UsernamePasswordAuthenticationFilter {
    private static final String COM_CODE_KEY = "com_code";

    public CustomSecurityFilter(AuthenticationSuccessHandler authenticationSuccessHandler){
        super.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    }

    protected String obtainComCode(HttpServletRequest request) {
        return request.getParameter(COM_CODE_KEY);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException {
        CustomAuthentication authRequestInfo = getAuthRequestInfo(request);

        this.getAuthenticationManager().authenticate(authRequestInfo);
        return authRequestInfo;
    }

    private CustomAuthentication getAuthRequestInfo(HttpServletRequest request){
        String username = obtainUsername(request);
        username = (username != null) ? username : "";
        String password = obtainPassword(request);
        password = (password != null) ? password : "";
        String comCode = obtainComCode(request);
        comCode = (comCode != null) ? comCode : "";

        return new CustomAuthentication(comCode, username, password);
    }



}
