package com.mathartsys;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
public class RestApplication extends ResourceConfig{
	public RestApplication() {  
		   
	     //���������ڵİ�·��  
	     packages("com.mathartsys.jerseyweb");  
	     //ע��JSONת����  
	     register(JacksonJsonProvider.class);  
	   
	    }  
}
