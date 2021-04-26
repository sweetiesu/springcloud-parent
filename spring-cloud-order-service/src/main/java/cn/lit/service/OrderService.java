package cn.lit.service;

public interface OrderService {
    /**
     * 支付订单 并增加用户积分
     * @param orderId 要支付的订单
     */
    void pay(String orderId);
}
