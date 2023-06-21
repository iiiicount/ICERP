package com.count.icount.auth.component.authorizationHandlers.handler;

import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.Model.enums.UserType;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
public class MasterOnlyAuthorizationHandler extends DefaultAuthorizationHandler{

    public MasterOnlyAuthorizationHandler(UserRepository userRepository, SecurityContextRepository securityContextRepository){
        super(userRepository, securityContextRepository);
    }

    @Override
    public User authorize(HttpServletRequest request){
        User user = super.authorize(request);

        if(user.getUserType() != UserType.MASTER){
            throw new AuthenticationFailedException("MASTER_ONLY");
        }

        return user;
    }

}
