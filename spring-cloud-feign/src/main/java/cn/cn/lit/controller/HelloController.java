package cn.cn.lit.controller;


import cn.cn.lit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService hs;
    //访问10000端口的/hello STRING NAME
    @RequestMapping("hello")
    public String sayHi(String name){
        return "FEIGN:"+hs.sayHi(name);
    }
}
