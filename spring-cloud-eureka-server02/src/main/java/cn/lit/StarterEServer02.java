package cn.lit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.InstanceRegistry;

@SpringBootApplication
//启动eureka服务端进程
@EnableEurekaServer
public class StarterEServer02 {
    public static void main(String[] args) {


        SpringApplication.run(StarterEServer02.class,args);
    }
}
