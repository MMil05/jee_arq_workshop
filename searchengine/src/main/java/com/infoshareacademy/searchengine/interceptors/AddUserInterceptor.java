package com.infoshareacademy.searchengine.interceptors;

import com.infoshareacademy.searchengine.domain.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class AddUserInterceptor {

    Logger logger = Logger.getLogger(AddUserInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        StringBuilder parameters = new StringBuilder();
        for (Object parameter : context.getParameters()) {
            parameters.append(((User) parameter).getId());
        }

        logger.info("Add user has been invoked with parameters User.ID " + parameters.toString() + "!");
        return context.proceed();
    }
}
