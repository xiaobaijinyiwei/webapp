package com.mathartsys.jerseyweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mathartsys.bean.User;


@Path("users1")
public class UserResource1 {
    public static Map<String,User> userMap = new HashMap<String,User>();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public User queryUserById(@PathParam("id") String id){
        System.out.println("***按id查询***");
        return userMap.get(id);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
//    public List<User> queryAllUser(){
//        System.out.println("***查询所有用户***");
//        List<User> users = new ArrayList<User>();
//        users.addAll(userMap.values());
//        return users;
//    }
    public String queryAllUser(){
		return "1234";
    }
    
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addUser(User user){
        System.out.println("***增加用户***");
        userMap.put(user.getUserId(), user);
    }
    
    
    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") String id){
        System.out.println("***删除用户***");
        userMap.remove(id);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public void updateUser(User user){
        System.out.println("***更新用户***");
        userMap.put(user.getUserId(), user);
    }
}
