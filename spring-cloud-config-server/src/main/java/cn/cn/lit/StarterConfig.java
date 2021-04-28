package cn.cn.lit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer//在启动工程时,启动配置中心服务端的进程
//根据配置文件读取gitee属性文件
@EnableEurekaClient
public class StarterConfig {
    public static void main(String[] args) {
        SpringApplication.run(StarterConfig.class,args);
    }
}
