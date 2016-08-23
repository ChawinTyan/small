package web.spring;

import facade.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.impl.LoginServiceImpl;

/**
 * Created by Administrator on 2016/6/16.
 */
@Configuration
@ComponentScan({"web.controller"})
public class SpringContextConfig {
    @Bean(name = "loginService")
    public LoginService loginService(){
        return new LoginServiceImpl();
    }
}
