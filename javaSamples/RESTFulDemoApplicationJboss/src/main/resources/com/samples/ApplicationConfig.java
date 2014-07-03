package com.samples;

import java.util.Arrays;

import javax.ws.rs.core.Application;

public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses(){
    	return new HashSet<Class<?>>(Arrays.asList(UserService.class))
    }
	
}
