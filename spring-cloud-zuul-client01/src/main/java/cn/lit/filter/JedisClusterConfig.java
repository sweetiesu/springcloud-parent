package cn.lit.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "cluster")
public class JedisClusterConfig {
    //准备多个为构造bean对象使用的属性们
    private List<String> nodes;//{"10.9.104.184:6379","",""}
    //连接池配置
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;
    @Bean //注解创建容器对象,会使用方法名称,默认对象id
    public JedisCluster initJedisCluster1(){
        //收集节点信息
        Set<HostAndPort> set=new HashSet<HostAndPort>();
        for(String node:nodes){
            String host=node.split(":")[0];
            int port=Integer.parseInt(node.split(":")[1]);
            set.add(new HostAndPort(host,port));
        }
        //连接池配置
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        return new JedisCluster(set,config);
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }
}
