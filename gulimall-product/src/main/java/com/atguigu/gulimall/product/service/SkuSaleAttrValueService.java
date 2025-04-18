package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.skuItemVo.SkuItemSaleAttrsVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author ericliu
 * @email ericliu.javadev@gmail.com
 * @date 2025-03-16 14:00:02
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SkuItemSaleAttrsVo> getSaleAttrsBySpuId(Long spuId);
}

