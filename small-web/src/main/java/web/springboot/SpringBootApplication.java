package web.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Created by tianwenyuan on 2016/6/6.
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan({"web.controller.security"})
public class SpringBootApplication{

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    public static void main(String args[]) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
