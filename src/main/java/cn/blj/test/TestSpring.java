package cn.blj.test;
import org.junit.Test;
import cn.blj.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 public class TestSpring {

    @Test
    public void run1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userService");
        userService.finfAll();

    }

}
