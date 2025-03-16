package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ericliu
 * @email ericliu.javadev@gmail.com
 * @date 2025-03-16 16:26:44
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
