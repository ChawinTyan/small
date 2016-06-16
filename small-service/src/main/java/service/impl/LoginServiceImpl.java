package service.impl;

import facade.service.LoginService;
import facade.vo.User;

/**
 * Created by Administrator on 2016/6/16.
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public User authByName(String userName) {
        User user = new User();
        user.setUserName(userName);
        user.setId(911);
        user.setStatus(1);
        user.setTelephoneNumber("1320982235");
        user.setUserCode("22299335");
        return user;
    }
}
