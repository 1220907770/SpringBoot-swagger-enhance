package com.swagger.enhance.controller;


import com.swagger.enhance.common.ApiResponse;
import com.swagger.enhance.entity.OrderInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.StringJoiner;

@Slf4j
@Api(tags = "工单管理" , value = "工单管理value")
@RestController
@RequestMapping("/order")
public class OrderInfoController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getOrderInfoById/{orderId}")
    @ApiOperation(value = "获取工单详情（DONE）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "orderId", value = "工单ID",  defaultValue = "xxx")})
    public ApiResponse<OrderInfo> getOrderInfoById(@PathVariable("orderId") String orderId){
        log.info("多个参数用  @ApiImplicitParams");
        return ApiResponse.<OrderInfo>builder().code(200)
                .data(new OrderInfo("1", "orderNo", "remark"))
                .message("成功").build();
    }

    @PostMapping("/getOrderInfoById")
    @ApiOperation(value = "获取工单详情（DONE）", notes = "备注")
    public ApiResponse<OrderInfo> getPage(@RequestBody OrderInfo orderInfo){
        log.info("多个参数用  @ApiImplicitParams");
        return ApiResponse.<OrderInfo>builder().code(200)
                .data(new OrderInfo("1", "orderNo", "remark"))
                .message("成功").build();
    }

    @RequestMapping("/getTest")
    public String getTest(@RequestParam("name") String name){
        log.info("多个参数用  @ApiImplicitParams");
        return "嘿嘿嘿嘿" + name;
    }


    @PostMapping("/getRedis")
    public String getRedis(HttpServletRequest request){
        log.info("redis");
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("name", "lcc");
        //  通配符  *
        Set<String> keys = stringRedisTemplate.keys("/*");

        StringJoiner sj = new StringJoiner(",");
        for (String key : keys) {
            String keyCount = valueOperations.get(key);
            sj.add(key +"  的请求次数: "+ keyCount);
            System.out.println(key + ": " + keyCount);
        }
        log.info("当前接口请求次数: {}", valueOperations.get(request.getRequestURI()));

        return "redis: 记录接口请求次数:  "  + sj.toString();
    }



}
