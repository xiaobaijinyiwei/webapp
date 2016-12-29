package com.mathartsys;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
public class RestApplication extends ResourceConfig{
	public RestApplication() {  
		   
	     //服务类所在的包路径  
	     packages("com.mathartsys.jerseyweb");  
	     //注册JSON转换器  
	     register(JacksonJsonProvider.class);  
	   
	    }  
}
