package web.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianwenyuan on 2016/6/3.
 */
@RestController
@RequestMapping("login1")
public class LoginController {
    @RequestMapping(value = "authByName1", method = RequestMethod.GET)
    public String authByName(){
        System.out.println("hello***********");
        return "hello,";
    }
}
