package cn.lit.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 注入使用restTemplate完成访问service-hi的过程
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate rtl;
    //添加hystrix提供的服务降级逻辑
    @HystrixCommand(fallbackMethod = "sayHiError")
    //fallbackMethod提供降级方法访问
    //本类中 需要一个该名称的方法,相同的参数,相同的返回值
    public String sayHi(String name) {
        //由于当前restTemplate创建时绑定了ribbon拦截逻辑
       return rtl.getForObject(
               "http://service-hi/sayHi?name="
                       +name,
                String.class);
        // hello world springcloud i am from 9001/9002
    }
    @HystrixCommand(fallbackMethod = "sayHi")
    public String sayHiError(String name){
        //返回个普通字符串,继续调用下一个负载均衡的请求
        return rtl.getForObject(
                "http://service-hi/sayHi?name="
                        +name,
                String.class);
        /*return "sorry,error happend";*/
    }
}
