package service.test;

import facade.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import web.spring.SpringContextConfig;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SpringContextConfig.class})
public class SpringBootTest {

//    @Autowired
//    private LoginService loginService;

    @Test
    public void testLogin(){

    }

}
