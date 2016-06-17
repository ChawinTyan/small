package facade.service;

import facade.vo.User;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public interface LoginService {
    public List<User> queryUsers(String userName);

    public Integer addUser(User user);
}
