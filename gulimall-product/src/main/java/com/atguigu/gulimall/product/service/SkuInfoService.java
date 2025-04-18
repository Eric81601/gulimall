package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.skuItemVo.SkuItemVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author ericliu
 * @email ericliu.javadev@gmail.com
 * @date 2025-03-16 14:00:02
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}

