package cn.blj.service;
import cn.blj.pojo.User;
import java.util.List;

/**
 * 业务层
 */
public interface UserService {
    //查找全部用户
    public List<User> finfAll();
    //保存用户信息
    public int savaUser(User user);
}
