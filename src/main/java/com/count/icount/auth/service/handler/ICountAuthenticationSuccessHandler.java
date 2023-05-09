package com.count.icount.auth.service.handler;

import com.count.icount.auth.model.securityModels.ICountAuthentication;
import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
    private String mainPageUrl;
    private String blockedUserPage;

    /*
    * 세션 저장하고
    * 메인화면으로 Redirect
    * */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ICountAuthentication auth = (ICountAuthentication) authentication;
        User user = User.of(userService.getUserByComCodeAndNickName(auth.getComCode(), auth.getName()));


        clearAuthenticationAttributes(request);
        //Cookie cookie = new Cookie();
        //this.getRedirectStrategy().sendRedirect(request, response, this.mainPageUrl);
    }

    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}
