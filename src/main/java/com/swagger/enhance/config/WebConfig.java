package com.swagger.enhance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现handlerInterceptor接口
 * 2、拦截器注册到容器中 实现WebMavInterceptor
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 要从容器中获取
    @Autowired
    RedisHandlerInterceptor redisHandlerInterceptor;
    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，写好的拦截器需要通过这里添加注册才能生效

        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new TestHandlerInterceptor())
                .addPathPatterns("/**")  //拦截所有请求
                .excludePathPatterns("/", "/order/**"); // 放行指定请求， eg: 登陆请求



        // 添加拦截的请求，记录请求接口 和 接口请求次数
        // 如果是:  new RedisHandlerInterceptor(); StringRedisTemplate 在容器中得不到, 会产生空指针,
        // 因为只有在容器中的组件，Spring才会解析@Autowired注解， 所以在容器中获取redisHandlerInterceptor
        registry.addInterceptor(redisHandlerInterceptor);
    }



}
