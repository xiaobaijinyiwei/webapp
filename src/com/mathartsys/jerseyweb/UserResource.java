
package com.mathartsys.jerseyweb;
 

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  
import javax.ws.rs.GET;  

import com.mathartsys.bean.User;

    @Path("/users")  
    public class UserResource {  
        private static Map<String,User> userMap = new HashMap<String,User>();
        
        @GET  
        @Produces(MediaType.APPLICATION_XML)  
        public String getAllUsers(){       
//            List<User> users = new ArrayList<User>();  
//            User u1 = new User("001","WayLau","26");  
//            User u2 = new User("002","King","23");  
//            User u3 = new User("003","Susan","21");  
//
//            userMap.put(u1.getUserId(), u1);  
//            userMap.put(u2.getUserId(), u2);  
//            userMap.put(u3.getUserId(), u3);  
//
//            users.addAll( userMap.values() );  
            return "1234";  
        }  

        @GET  
        @Path("/getUserXml")  
        @Produces(MediaType.APPLICATION_XML)  
        public User getUserXml() {  
         User user  = new User();  
         user.setAge("21");  
         user.setUserId("004");  
         user.setUserName("Amand");  
         return user;  
        }  
        
        @GET    
        @Path("/getUserJson")    
        @Produces(MediaType.APPLICATION_JSON)    
        public User getUserJson() {    
         User user  = new User();    
         user.setAge("27");    
         user.setUserId("005");    
         user.setUserName("Fmand");    
         return user;    
        }   
    }  