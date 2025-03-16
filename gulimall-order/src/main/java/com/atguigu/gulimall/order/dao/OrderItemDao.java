package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author ericliu
 * @email ericliu.javadev@gmail.com
 * @date 2025-03-16 16:29:24
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
