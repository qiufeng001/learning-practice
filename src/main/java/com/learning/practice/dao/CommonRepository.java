package com.learning.practice.dao;

import com.learning.practice.base.Common;
import com.learning.practice.base.IRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 公共模块
 */
@Mapper
public interface CommonRepository extends IRepository<Common, String> {

    /**
     * 查询出该用户操作数据库的权限（增删改查权限）
     * @param params
     * @return
     */
    Common findMaxSequence(@Param("params") Map<String, Object> params);
}
