package cn.lit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("cn.lit.mapper")
@EnableEurekaClient
public class StarterOrder {
    public static void main(String[] args) {
        SpringApplication.run(StarterOrder.class,args);
    }
    /*创建一个RestTemplate对象交给spring框架维护*/
    @Bean//ribbon实现拦截的负载均衡
    @LoadBalanced
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
}
