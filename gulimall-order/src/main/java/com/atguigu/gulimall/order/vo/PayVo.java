package com.atguigu.gulimall.order.vo;

import lombok.Data;

@Data
public class PayVo {
    private String out_trade_no; //订单号
    private String subject; //订单名称
    private String total_amount; //订单金额
    private String body; //订单描述
}
