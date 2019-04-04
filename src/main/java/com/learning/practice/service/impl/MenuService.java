package com.learning.practice.service.impl;

import com.learning.practice.base.BaseEntity;
import com.learning.practice.base.Common;
import com.learning.practice.base.Pagenation;
import com.learning.practice.dao.MenuRepository;
import com.learning.practice.entity.Menu;
import com.learning.practice.entity.RoleMenu;
import com.learning.practice.service.IMenuService;
import com.learning.practice.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<Menu> selectByAccount(Map<String, Object> params) {
        return repository.selectByAccount(params);
    }

    @Override
    public List<Menu> selectPid() {
        return repository.selectPid();
    }

    @Override
    public Menu findByPrimaryKey(String id) {
        return repository.findByPrimaryKey(id);
    }

    @Override
    public Menu findByParam(Map<String, Object> params) {
        return repository.findByParam(params);
    }


    @Override
    public Integer selectCount(Map<String, Object> params) {
        return repository.selectCount(params);
    }

    @Override
    public List<Menu> selectByPage(Map<String, Object> params, Pagenation page) {
        return repository.selectByPage(params, page, "");
    }

    @Override
    public Integer insert(Menu entry) {
        initEntry(entry);
        return repository.insert(entry);
    }

    @Override
    public Integer update(Menu entry) {
        return repository.update(entry);
    }

    @Override
    public Integer deleteByPrimaryKey(String id) {
        return repository.deleteByPrimaryKey(id);
    }

    @Override
    public Integer validate(Map<String, Object> params) {
        return repository.validate(params);
    }

    protected void initEntry(Menu entry) {
        Menu item = entry;
        Date d = new Date();
        item.setCreateTime(d);
        item.setUpdateTime(d);
        item.setUpdateUser(item.getCreateUser());
        item.setId(UUIDUtils.getUUID());
    }
}
