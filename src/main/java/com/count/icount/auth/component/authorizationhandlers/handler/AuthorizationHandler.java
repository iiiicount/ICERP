package com.count.icount.auth.component.authorizationhandlers.handler;

import com.count.icount.company.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthorizationHandler {
    User authorize(HttpServletRequest request);
}
