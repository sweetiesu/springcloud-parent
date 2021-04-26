package cn.lit.controller;

import cn.lit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService = null;

    @ResponseBody
    @RequestMapping("/pay.action")
    public String pay(String orderId){
        orderService.pay(orderId);
        return "1";
    }
}
