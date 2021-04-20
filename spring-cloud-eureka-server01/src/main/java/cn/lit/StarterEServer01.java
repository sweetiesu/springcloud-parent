package cn.lit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心
 *
 */
@SpringBootApplication
//启动eureka服务端进程的注解
@EnableEurekaServer
public class StarterEServer01
{
    public static void main( String[] args )
    {
        SpringApplication.run(StarterEServer01.class,args);
    }
}
