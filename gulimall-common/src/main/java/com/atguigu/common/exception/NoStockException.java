package com.atguigu.common.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoStockException extends RuntimeException {
    private Long skuId;

    public NoStockException(Long skuId) {
        super(skuId + "号商品没有足够的库存");
    }

    public NoStockException(String msg) {
        super(msg);
    }
}
