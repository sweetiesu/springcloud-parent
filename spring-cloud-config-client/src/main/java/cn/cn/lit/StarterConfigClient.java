package cn.cn.lit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StarterConfigClient {
    @Value("${name}")
    public String name;
    public static void main(String[] args) {
        SpringApplication.run(StarterConfigClient.class,args);
    }
}
