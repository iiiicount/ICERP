package com.count.icount.auth.filter;

import com.count.icount.auth.model.securityModels.ICountAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextRepository;

public class ICountSecurityFilter extends UsernamePasswordAuthenticationFilter {
    private static final String COM_CODE_KEY = "com_code";

    public ICountSecurityFilter(
            AuthenticationSuccessHandler authenticationSuccessHandler,
            AuthenticationFailureHandler authenticationFailureHandler
    ){
        super.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        super.setAuthenticationFailureHandler(authenticationFailureHandler);
    }

    public ICountSecurityFilter(
            AuthenticationSuccessHandler authenticationSuccessHandler,
            AuthenticationFailureHandler authenticationFailureHandler,
            SecurityContextRepository securityContextRepository

            ){
        super.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        super.setAuthenticationFailureHandler(authenticationFailureHandler);
        super.setSecurityContextRepository(securityContextRepository);
    }

    protected String obtainComCode(HttpServletRequest request) {
        return request.getParameter(COM_CODE_KEY);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)throws AuthenticationException {
        ICountAuthentication authRequestInfo = getAuthRequestInfo(request);

        this.getAuthenticationManager().authenticate(authRequestInfo);
        return authRequestInfo;
    }

    private ICountAuthentication getAuthRequestInfo(HttpServletRequest request){
        String username = obtainUsername(request);
        username = (username != null) ? username : "";
        String password = obtainPassword(request);
        password = (password != null) ? password : "";
        String comCode = obtainComCode(request);
        comCode = (comCode != null) ? comCode : "";

        return new ICountAuthentication(comCode, username, password);
    }



}
