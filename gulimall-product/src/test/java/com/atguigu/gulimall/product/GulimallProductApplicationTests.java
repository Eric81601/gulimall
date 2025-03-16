package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setName("xiaomi");
//        brandEntity.setName("huawei");
//        brandService.save(brandEntity);
//        System.out.println("保存成功!");
//        brandService.updateById(brandEntity);
        brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L)).forEach(System.out::println);
    }
}
