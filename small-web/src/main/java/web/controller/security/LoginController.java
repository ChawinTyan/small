package web.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianwenyuan on 2016/6/3.
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @RequestMapping(value = "authByName", method = RequestMethod.GET)
    public String authByName(String userName){
        return "hello," + userName;
    }
}
