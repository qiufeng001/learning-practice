package com.learning.practice.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IService<T extends IEntity, K> {

    T findByParam(Map<String, Object> params);

    T findByPrimaryKey(K id);

    public Integer selectCount(Map<String, Object> params);

    public List<T> selectByPage(Map<String, Object> params, Pagenation page);

    public Integer insert(T entry);

    public Integer update(T entry);

    public Integer deleteByPrimaryKey(K id);

    public Integer validate(Map<String, Object> params);
}
