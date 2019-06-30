package cn.blj.test;

import cn.blj.util.RedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class TestRedisPool {

   @Test
   public void run1(){
       String host="192.168.1.9";
       int port =6379;
       JedisPool pool =null;
       Jedis jedis =null;
      try {
           pool = RedisUtils.open(host, 6379);
           jedis = pool.getResource();
          jedis.set("break","油条稀饭2");
          System.out.println("break key :"+jedis.get("break"));

          jedis.mset("lunch","肉末茄子盖浇饭2","dinner","面条2");
          List<String> mget = jedis.mget("break","lunch", "dinner");
          for(String val:mget){
              System.out.println(val);
          }
      }finally {
          RedisUtils.close();
      }

   }

}
