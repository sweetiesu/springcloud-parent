package cn.lit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//开启zuul网关的注解
@EnableZuulProxy
@EnableEurekaClient
public class StarterZuul01 {
    public static void main(String[] args) {
        SpringApplication.run(StarterZuul01.class,args);
    }
}
