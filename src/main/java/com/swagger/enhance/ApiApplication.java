package com.swagger.enhance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.swagger.enhance")
public class ApiApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApiApplication.class, args);
     /*   for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println("默认加载IOC容器+部分手动导入第三方容器 : " +  beanDefinitionName);
        }*/

        System.out.println("加载IOC容器总个数" +  run.getBeanDefinitionCount());

        System.out.println(run.getBeanNamesForType(CacheManager.class).length);

        System.out.println(run.getBeanNamesForType(CacheAspectSupport.class).length);
    }

}
