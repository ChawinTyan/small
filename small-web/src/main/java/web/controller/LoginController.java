package web.controller;

import com.alibaba.druid.pool.DruidDataSource;
import facade.service.LoginService;
import facade.vo.User;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
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
    private DataSource dataSource;

    @ApiOperation(value = "获取用户列表", notes = "用来获取全部用户信息")
    @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "String")
    @RequestMapping(value = "queryUsers", method = RequestMethod.GET)
    public List<User> queryUsers(String userName){
        LOG.info("【请求用户名.{}】", userName);
        return loginService.queryUsers(userName);
    }

    @ApiOperation(value = "新增用户", notes = "添加用户信息")
    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    public User addUser(HttpServletRequest request){
        User user = new User();
        user.setUserCode(request.getParameter("userCode"));
        user.setUserName(request.getParameter("userName"));
        user.setTelephoneNumber(request.getParameter("telephoneNumber"));
        user.setStatus(Integer.valueOf(request.getParameter("status")));
        LOG.info("【请求用户信息.{}】", user.toString());
        loginService.addUser(user);
        return user;
    }

}
