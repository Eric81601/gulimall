package com.atguigu.gulimall.cart.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> Items;
    private Integer countNum;
    private Integer countType;
    private BigDecimal totalAmount;
    private BigDecimal reduce = new BigDecimal(0);

    public Integer getCountNum() {
        int count = 0;
        if (Items != null && !Items.isEmpty()) {
            for (CartItem item : Items) {
                count += item.getCount();
            }
        }
        return count;
    }

    public Integer getCountType() {
        int count = 0;
        if (Items != null && !Items.isEmpty()) {
            for (CartItem item : Items) {
                count += 1;
            }
        }
        return count;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal(0);
        //1.计算购物车所有商品总价
        if (Items != null && !Items.isEmpty()) {
            for (CartItem item : Items) {
                if (Boolean.TRUE.equals(item.getCheck())) {
                    BigDecimal totalPrice = item.getTotalPrice();
                    amount = amount.add(totalPrice);
                }
            }
        }
        //2.减去优惠价格
        return amount.subtract(getReduce());
    }
}
