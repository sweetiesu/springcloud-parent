package cn.lit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //唯一测试案例访问sayHi返回一句话
    @RequestMapping("sayHi")
    public String sayHi(String name){
        //定义标识，告诉访问的客户端当前响应是从9001
        return "hello world springcloud i am from 9002";
    }
}
