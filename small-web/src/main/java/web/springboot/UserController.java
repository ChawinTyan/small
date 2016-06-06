package web.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianwenyuan on 2016/6/3.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping(value = "query")
    public String authByName(){
        System.out.println("apollo *** ");
        return "apollo";
    }
}
