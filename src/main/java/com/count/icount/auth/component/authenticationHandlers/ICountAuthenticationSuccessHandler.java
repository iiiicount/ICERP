package com.count.icount.auth.component.authenticationHandlers;

import com.count.icount.auth.model.dto.LoginResponseDto;
import com.count.icount.auth.model.securityModels.ICountAuthentication;
import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.Model.enums.UserType;
import com.count.icount.company.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ICountAuthenticationSuccessHandler
        extends AbstractAuthenticationTargetUrlRequestHandler
        implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    private final UserService userService;
    private final ObjectMapper mapper;
    private String mainPageUrl = "https://develop.duo2enykevpt3.amplifyapp.com/";
    private String blockedUserPage = "https://develop.duo2enykevpt3.amplifyapp.com/";

    /*
    * 세션 저장하고
    * 메인화면으로 Redirect
    * */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ICountAuthentication auth = (ICountAuthentication) authentication;
        User user = User.of(userService.getUserByComCodeAndNickName(auth.getComCode(), auth.getName()));

        String redirectUrl = this.mainPageUrl;
        if(user.getUserType() == UserType.BLOCKED){
            redirectUrl = this.blockedUserPage;
        }

        clearAuthenticationAttributes(request);

        var loginResponse = new LoginResponseDto(true, null, "");

        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), new ResponseEntity<>(loginResponse, HttpStatus.OK));
    }
    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}
