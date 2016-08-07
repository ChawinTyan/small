package web.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianwenyuan on 2016/6/16.
 */
@Api
@Profile("development")
@RestController
@RequestMapping("register")
public class RegisterController {
    private Logger LOG = LoggerFactory.getLogger(RegisterController.class);
    @RequestMapping(value = "registerByEmail", method = RequestMethod.GET)
    public String authByName(String userName){
        LOG.info("【注册用户名.{}】", userName);
        return "hello," + userName;
    }
}
