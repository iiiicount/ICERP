package com.count.icount.annotation.resolver;

import com.count.icount.annotation.AuthInfo;
import com.count.icount.annotation.AuthUserInfo;
import com.count.icount.auth.model.securityModels.ICountAuthentication;
import com.count.icount.exception.AuthenticationFailedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class AuthInfoResolver implements HandlerMethodArgumentResolver {
    private final SecurityContextRepository securityContextRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(AuthInfo.class) != null &&
                parameter.getParameterType().equals(AuthUserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        if(!securityContextRepository.containsContext(request)){
            throw new AuthenticationFailedException();
        }

        ICountAuthentication authentication = (ICountAuthentication) securityContextRepository.loadDeferredContext(request).get().getAuthentication();

        // 유효한 유저인지 체크하는 로직;

        return AuthUserInfo.convertToUserInfo(authentication, request);
    }
}
