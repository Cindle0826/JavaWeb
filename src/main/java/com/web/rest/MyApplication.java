package com.web.rest;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        //註冊 Rest service
        Set<Class<?>> classes = new LinkedHashSet();
        classes.add(HelloService.class);
        classes.add(BMIService.class);
        classes.add(BookService.class);
         return classes;
    }

}
