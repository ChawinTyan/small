package facade.service;

import facade.vo.User;

/**
 * Created by Administrator on 2016/6/16.
 */
public interface LoginService {
    public User authByName(String userName);
}
