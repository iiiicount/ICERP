package com.count.icount.auth.component.authorizationhandlers.handler;

import com.count.icount.auth.model.securitymodels.ICountAuthentication;
import com.count.icount.company.model.entity.User;
import com.count.icount.company.model.enums.UserType;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultAuthorizationHandler implements AuthorizationHandler{
    private final UserRepository userRepository;
    private final SecurityContextRepository securityContextRepository;


    // region [Private Methods]
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

    // endregion

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
