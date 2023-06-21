package com.count.icount.auth.component.authorizationHandler.handler;

import com.count.icount.company.Model.Entity.User;
import com.count.icount.model.AuthUserInfo;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthorizationHandler {
    User authorize(HttpServletRequest request);
}
