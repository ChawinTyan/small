package web.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tianwenyuan on 2016/6/6.
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan({"web.controller.security"})
public class SpringBootApplication{
    public static void main(String args[]) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
