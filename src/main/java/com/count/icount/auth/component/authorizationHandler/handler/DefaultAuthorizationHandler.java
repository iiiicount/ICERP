package com.count.icount.auth.component.authorizationHandler.handler;

import com.count.icount.auth.model.securityModels.ICountAuthentication;
import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.Model.enums.UserType;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import com.count.icount.model.AuthUserInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultAuthorizationHandler implements AuthorizationHandler{
    private final UserRepository userRepository;
    private final SecurityContextRepository securityContextRepository;

    private ICountAuthentication getAuthentication(HttpServletRequest request){

        if(!securityContextRepository.containsContext(request)){
            throw new AuthenticationFailedException();
        }

        return (ICountAuthentication) securityContextRepository.loadDeferredContext(request).get().getAuthentication();
    }

    private User getUser(ICountAuthentication authentication){
        String comCode = authentication.getComCode();
        String username = authentication.getName();

        return userRepository.findByComCodeAndUserName(comCode, username)
                .orElseThrow(AuthenticationFailedException::new);
    }

    @Override
    public User authorize(HttpServletRequest request) {

        ICountAuthentication authentication = this.getAuthentication(request);

        User user = this.getUser(authentication);

        if(user.getUserType() == UserType.BLOCKED){
            throw new AuthenticationFailedException("BLOCKED_USER");
        }

        return user;
    }
}
