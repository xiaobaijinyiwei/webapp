package com.mathartsys.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.mathartsys.bean.User;


public class ClientTest {
	private static String url = "http://localhost:8080/webapp/web";
    public static void main(String args[]){
    		add();
    		update();
    		delete();
    		query();
    		//testMapMothed();
    }
    
    
    /*
     
        public static void main(String[] args) {  
        String url = "http://192.168.1.134:8080/MyJersey/rest";  
        Client client = ClientBuilder.newClient();  
        WebTarget webTarget = client.target(url).path("HelloWorld").path("sayHello/admin");  
        Builder builder = webTarget.request(MediaType.APPLICATION_JSON);  
        String result = builder.get(String.class);  
        System.out.println(result);  
    } 
     
     
      */
    
    
    private static void add(){
//        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);    //客户端如果需要进行JSON转换，需要进行JSON注册

    	Client client = ClientBuilder.newClient();
    	 
        WebTarget target = client.target(url).path("users1");

        User user = new User("002","Andy","20");

        Response response = target.request().buildPost(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();

        response.close();

    }
    private static void query(){
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);        
        WebTarget target = client.target(url).path("users1").path("002");

        Response response1 = target.request().get();

        User u = response1.readEntity(User.class);
        if(u == null ||u.equals(null)){
            System.out.println("没有查询的内容");
            response1.close();
        }else{
            System.out.println(u.getUserId());
            System.out.println(u.getUserName());
            System.out.println(u.getAge());
            
        }
    }
    private static void delete(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url).path("users1").path("002");
        Response response = target.request().delete();
        response.close();
    }
    
    private static void update(){
        User user = new User();
        user.setUserId("002");
        user.setUserName("回嘉");
        user.setAge("30");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url).path("users1");
        Response response = target.request().buildPut(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();
        response.close();
    }
    
    private static void testMapMothed(){
        Map<String , Object> maps = new HashMap<String,Object>();
        User user = new User("1","an","20");
        maps.put("002",user );
        User user1 = new User("2","and","30");
        maps.put("003",user1);
        
        Iterator i = maps.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry map = (Entry) i.next();
            System.out.println(map.getKey());
            User useri = (User) map.getValue();
            System.out.println(useri.getUserName());
        }
    }

}
