package web.controller;

import com.alibaba.druid.pool.DruidDataSource;
import facade.service.LoginService;
import facade.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tianwenyuan on 2016/6/3.
 */
@Profile("production")
@RestController
@RequestMapping("login")
public class LoginController {

    private Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private List<DruidDataSource> druidDataSource;

    @RequestMapping(value = "authByName", method = RequestMethod.GET)
    public String authByName(String userName){
        LOG.info("【请求用户名.{}】", druidDataSource.size());
        LOG.info("【请求用户名.{}】", userName);
        User user = loginService.authByName(userName);
        return user.toString();
    }
}
