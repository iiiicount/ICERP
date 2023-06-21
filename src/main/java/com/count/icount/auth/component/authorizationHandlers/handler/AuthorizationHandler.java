package com.count.icount.auth.component.authorizationHandlers.handler;

import com.count.icount.company.Model.Entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthorizationHandler {
    User authorize(HttpServletRequest request);
}
