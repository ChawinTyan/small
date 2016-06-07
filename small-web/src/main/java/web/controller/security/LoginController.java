package web.controller.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianwenyuan on 2016/6/3.
 */
@RestController
@RequestMapping("login")
public class LoginController {
    private Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = "authByName", method = RequestMethod.GET)
    public String authByName(String userName){
        LOG.info("【请求用户名.{}】", userName);
        return "hello," + userName;
    }
}
