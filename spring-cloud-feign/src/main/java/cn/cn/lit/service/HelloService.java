package cn.cn.lit.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
动态代理实现逻辑：
    该接口类中，添加多个注解似的抽象方法可以在动态代理
    实现调用restTemplate的逻辑
    getForObject("http://service-hi/sayHi?name=wang")
 */

@FeignClient("service-hi")//该接口类的所有抽象方法
//都会在发送请求时找到service-hi的服务
//client.getForObject(url="http://service-hi/sayHi")
public interface HelloService {
    //在抽象方法上实现springmvc注解使用,动态代理加载的注解
    @RequestMapping(value="sayHi",method= RequestMethod.GET)
    String sayHi(@RequestParam("name") String name);
}
