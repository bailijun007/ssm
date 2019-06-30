package cn.blj.service.impl;

import cn.blj.dao.UserDao;
import cn.blj.pojo.User;
import cn.blj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> finfAll() {
        System.out.println("业务层：查询所有用户信息");
        return userDao.finfAll();
    }

    @Transactional(readOnly = false)
    public int savaUser(User user) {
       int num= userDao.savaUser(user);
       // System.out.println("业务层：保存用户信息");
        return num;
    }
}
