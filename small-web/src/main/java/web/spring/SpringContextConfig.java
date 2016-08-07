package web.spring;

import facade.service.LoginService;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

    @Bean
    public ApiListingResource apiListingResource(){
        return new ApiListingResource();
    }

    @Bean
    public SwaggerSerializers swaggerSerializers(){
        return new SwaggerSerializers();
    }

    @Bean
    public BeanConfig beanConfig(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Swagger Sample App");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9191");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
        return beanConfig;
    }
}
