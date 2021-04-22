package cn.lit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StarterClient01 {
    public static void main(String[] args) {
        SpringApplication.run(StarterClient01.class,args);
    }
}
