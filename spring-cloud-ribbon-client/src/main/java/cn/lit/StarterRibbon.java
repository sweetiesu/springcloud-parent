package cn.lit;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@EnableDiscoveryClient
public class StarterRibbon {
    public static void main(String[] args) {
        SpringApplication.run(StarterRibbon.class,args);
    }
    //生成一个RestTemplate的spring管理对象
    //创建过程需要整合ribbon拦截逻辑
    //http://service-hi/sayHi?name=wang
    @Bean
    @LoadBalanced//负载均衡的ribbon拦截器注解
    //RestTemplate 实现方法发送请求的拦截逻辑
    public RestTemplate initTemplate(){
        return new RestTemplate();
    }

    //创建一个IRule实现类对象
    @Bean
    public IRule initRule(){
        //RandomRule;
        //WeightedResponseTimeRule;
        return new RandomRule();
    }
}
