package cn.blj.test;

import cn.blj.dao.UserDao;
import cn.blj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

   @Test
   public void run1() throws IOException {

      /* InputStream in = Resources.getResourceAsStream("mybatisConfig.xml");
       SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
       SqlSession session = factory.openSession();
       UserDao dao = session.getMapper(UserDao.class);
       List<User> users = dao.finfAll();
       System.out.println(users);*/
   }

}
