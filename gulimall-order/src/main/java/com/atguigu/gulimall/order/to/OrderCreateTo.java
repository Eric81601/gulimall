package com.atguigu.gulimall.order.to;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.atguigu.gulimall.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderCreateTo {
    private OrderEntity order; //订单信息
    private List<OrderItemEntity> items; //订单项信息
    private BigDecimal payPrice; //订单计算的价格
    private BigDecimal fare; //运费
}
