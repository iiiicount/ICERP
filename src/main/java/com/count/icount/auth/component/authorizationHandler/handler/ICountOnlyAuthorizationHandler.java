package com.count.icount.auth.component.authorizationHandler.handler;

import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.Model.enums.UserType;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
public class ICountOnlyAuthorizationHandler extends DefaultAuthorizationHandler {

    public ICountOnlyAuthorizationHandler(UserRepository userRepository, SecurityContextRepository securityContextRepository){
        super(userRepository, securityContextRepository);
    }

    @Override
    public User authorize(HttpServletRequest request){
        User user = super.authorize(request);
        UserType userType = user.getUserType();

        if(userType != UserType.ICOUNT && userType != UserType.ICOUNT_MASTER){
            throw new AuthenticationFailedException("ICOUNT_ONLY");
        }

        return user;
    }
}
