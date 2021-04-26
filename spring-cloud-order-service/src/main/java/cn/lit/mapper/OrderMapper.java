package cn.lit.mapper;

import cn.lit.domain.Order;

public interface OrderMapper {
    /**
     * 根据订单编号查询订单信息
     * @param orderId 要查询的订单编号
     * @return 查找到的订单bean
     */
    Order queryOrder(String orderId);
}
