package com.count.icount.annotation;

import com.count.icount.auth.model.enums.AuthorizationMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthInfo {
    AuthorizationMode mode() default AuthorizationMode.DEFAULT;
}
