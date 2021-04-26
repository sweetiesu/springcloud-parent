package cn.lit.service;

import cn.lit.domain.Order;
import cn.lit.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper = null;
    @Autowired
    private RestTemplate client;
    public void pay(String orderId) {
        //1.查询订单
        Order order = orderMapper.queryOrder(orderId);
        //2.将订单置位已支付
        System.out.println("将订单"+orderId+"置位已支付..");
        //通过restTemplate发起向user系统的请求
        //按照接口发送 String userId Integer money
        String userId=order.getUserId();
        Integer money=order.getOrderMoney();
        //每个支付请求，形成大量的并发后，负载均衡 nginx
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("userId",userId);
        params.put("money",money);
        client.getForObject("http://user-test/user/addPoint.action?userId={userId}&money={money}",Integer.class,params);
    }
}
