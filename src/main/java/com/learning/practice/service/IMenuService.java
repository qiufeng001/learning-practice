package com.learning.practice.service;

import com.learning.practice.entity.Menu;
import com.learning.practice.base.IService;

import java.util.List;
import java.util.Map;


public interface IMenuService extends IService<Menu, String> {

    /**
     * 根据用户的账号查询该用户可以看到的菜单
     *
     * @return 菜单集合
     */
    public List<Menu> selectByAccount(Map<String, Object> params);

    /**
     * 查询pid
     * @return
     */
    List<Menu> selectPid();
}
