package com.bookshop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bookshop.enums.ControllerType;
import com.bookshop.enums.UserRole;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
	
	ControllerType type() default ControllerType.NORMAL;
	
	UserRole requiredRole() default UserRole.NORMAL;
}
