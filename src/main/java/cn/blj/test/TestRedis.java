package cn.blj.test;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import java.util.List;

public class TestRedis {
    @Test
   public void run1(){
      String host="192.168.58.1";
       int port =6379;
       Jedis jedis=new Jedis(host,port);
       jedis.auth("123456");
       jedis.set("break","油条稀饭");
       System.out.println("break key :"+jedis.get("break"));

       jedis.mset("lunch","肉末茄子盖浇饭","dinner","面条");
       List<String> mget = jedis.mget("break","lunch", "dinner");
        for(String val:mget){
            System.out.println(val);
        }
   }



}
