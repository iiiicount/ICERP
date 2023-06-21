package com.count.icount.auth.component.authorizationHandlers;

import com.count.icount.auth.component.authorizationHandlers.handler.AuthorizationHandler;
import com.count.icount.auth.component.authorizationHandlers.handler.DefaultAuthorizationHandler;
import com.count.icount.auth.component.authorizationHandlers.handler.ICountOnlyAuthorizationHandler;
import com.count.icount.auth.component.authorizationHandlers.handler.MasterOnlyAuthorizationHandler;
import com.count.icount.auth.model.enums.AuthorizationMode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizationHandlerFactory {
    private final DefaultAuthorizationHandler defaultAuthorizationHandler;
    private final MasterOnlyAuthorizationHandler masterOnlyAuthorizationHandler;
    private final ICountOnlyAuthorizationHandler iCountOnlyAuthorizationHandler;

    public AuthorizationHandler createHandler(AuthorizationMode mode){
        return switch (mode) {
            case ICOUNT_ONLY -> iCountOnlyAuthorizationHandler;
            case MASTER_ONLY -> masterOnlyAuthorizationHandler;
            default -> defaultAuthorizationHandler;
        };
    }
}
