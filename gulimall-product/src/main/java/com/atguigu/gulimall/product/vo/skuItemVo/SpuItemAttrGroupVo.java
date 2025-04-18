package com.atguigu.gulimall.product.vo.skuItemVo;

import com.atguigu.gulimall.product.vo.Attr;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<Attr> attrValues;
}
