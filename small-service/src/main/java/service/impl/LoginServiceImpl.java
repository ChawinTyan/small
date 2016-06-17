package service.impl;

import facade.persistence.UserMapper;
import facade.service.LoginService;
import facade.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUsers(String userName) {
        return userMapper.queryUsers();
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

}
