package com.count.icount.auth.component.authenticationhandlers;

import com.count.icount.auth.model.dto.LoginResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ICountAuthenticationFailedHandler implements AuthenticationFailureHandler {
    private final ObjectMapper mapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        var loginFailedResponse = new LoginResponseDto(false, "Authentication_failed", "아이디 혹은 비밀번호를 확인하세요");
        mapper.writeValue(response.getWriter(), new ResponseEntity<>(loginFailedResponse, HttpStatus.UNAUTHORIZED));
    }
}
