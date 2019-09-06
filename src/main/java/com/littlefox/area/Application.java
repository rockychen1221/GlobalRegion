package com.littlefox.area;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@MapperScan("com.littlefox.**.dao")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        //接收请求参数包含{}等特殊字符
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","|{}");
        //所有的bean,参考：http://412887952-qq-com.iteye.com/blog/2314051
        String[] beanNames = ctx.getBeanDefinitionNames();
        //String[] beanNames = ctx.getBeanNamesForAnnotation(RestController.class);//所有添加该注解的bean
        log.info("bean总数:{}", ctx.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
            log.info("{},beanName:{}", ++i, str);
        }
    }

}
