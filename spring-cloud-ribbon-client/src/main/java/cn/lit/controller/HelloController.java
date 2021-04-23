package cn.lit.controller;

import cn.lit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService hs;
    //请求地址 /hello
    //请求参数 String name
    //返回数据 需要调用service-hi服务提供者获取
    @RequestMapping("/hello")
    public String sayHi(String name){
        return "RIBBON:"+hs.sayHi(name);
    }
}
