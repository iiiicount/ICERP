package com.count.icount.annotation.resolver;

import com.count.icount.annotation.AuthInfo;
import com.count.icount.auth.component.authorizationhandlers.AuthorizationHandlerFactory;
import com.count.icount.auth.component.authorizationhandlers.handler.AuthorizationHandler;
import com.count.icount.auth.model.enums.AuthorizationMode;
import com.count.icount.model.AuthUserInfo;
import com.count.icount.company.model.entity.User;
import com.count.icount.exception.AuthenticationFailedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthInfoResolver implements HandlerMethodArgumentResolver {
    private final AuthorizationHandlerFactory authorizationHandlerFactory;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(AuthInfo.class) != null &&
                parameter.getParameterType().equals(AuthUserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        var annotation = Optional.ofNullable(parameter.getParameterAnnotation(AuthInfo.class))
                .orElseThrow(AuthenticationFailedException::new);
        var authorizationMode = annotation.mode();

        if(authorizationMode == null){
            authorizationMode = AuthorizationMode.DEFAULT;
        }

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        AuthorizationHandler authHandler = this.authorizationHandlerFactory.createHandler(authorizationMode);
        User user = authHandler.authorize(request);

        return AuthUserInfo.convertToUserInfo(user, request);
    }
}
