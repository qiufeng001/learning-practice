package com.learning.practice.base;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IRepository<T extends Serializable, K> {

    T findByPrimaryKey(K var1);

    T findByParam(@Param("params") Map<String, Object> var1);

    Integer selectCount(@Param("params") Map<String, Object> var1);

    List<T> selectByPage(@Param("params") Map<String, Object> var1, @Param("page") Pagenation var2, @Param("orderby") String var3);

    List<T> selectByParams(@Param("params") Map<String, Object> var1, @Param("orderby") String var2);

    void selectByParams(@Param("params") Map<String, Object> var1, @Param("orderby") String var2, ResultHandler<T> var3);

    Integer insert(T var1);

    Integer update(T var1);

    Integer deleteByParams(@Param("params") Map<String, Object> var1);

    Integer deleteByPrimaryKey(K var1);

    Integer validate(@Param("params") Map<String, Object> var1);
}

