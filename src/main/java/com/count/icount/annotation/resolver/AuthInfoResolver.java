package com.count.icount.annotation.resolver;

import com.count.icount.annotation.AuthInfo;
import com.count.icount.auth.component.authorizationHandler.AuthorizationHandlerFactory;
import com.count.icount.auth.component.authorizationHandler.handler.AuthorizationHandler;
import com.count.icount.auth.model.enums.AuthorizationMode;
import com.count.icount.model.AuthUserInfo;
import com.count.icount.auth.model.securityModels.ICountAuthentication;
import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthInfoResolver implements HandlerMethodArgumentResolver {
    private final SecurityContextRepository securityContextRepository;
    private final UserRepository userRepository;
    private final AuthorizationHandlerFactory authorizationHandlerFactory;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(AuthInfo.class) != null &&
                parameter.getParameterType().equals(AuthUserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        var annotation = Optional.ofNullable(parameter.getParameterAnnotation(AuthInfo.class))
                .orElseThrow(AuthenticationFailedException::new);

        var authorizationMode = annotation.mode();

        if(authorizationMode == null){
            authorizationMode = AuthorizationMode.DEFAULT;
        }

        AuthorizationHandler authHandler = this.authorizationHandlerFactory.createHandler(authorizationMode);

        User user = authHandler.authorize(request);

        return AuthUserInfo.convertToUserInfo(user, request);
    }
}
