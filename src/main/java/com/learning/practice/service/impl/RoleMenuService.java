package com.learning.practice.service.impl;

import com.learning.practice.base.Common;
import com.learning.practice.base.IRepository;
import com.learning.practice.base.Pagenation;
import com.learning.practice.dao.RoleMenuRepository;
import com.learning.practice.entity.Menu;
import com.learning.practice.entity.RoleMenu;
import com.learning.practice.service.IRoleMenuService;
import com.learning.practice.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class RoleMenuService implements IRoleMenuService {

	@Autowired
	private RoleMenuRepository repository;

	@Override
	public Integer validateRoleMenu(String roleNo, String menuId) {
		return repository.validateRoleMenu(roleNo, menuId);
	}

	@Override
	public RoleMenu findByPrimaryKey(String id) {
		return repository.findByPrimaryKey(id);
	}

	@Override
	public RoleMenu findByParam(Map<String, Object> params) {
		return repository.findByParam(params);
	}


	@Override
	public Integer selectCount(Map<String, Object> params) {
		return repository.selectCount(params);
	}

	@Override
	public List<RoleMenu> selectByPage(Map<String, Object> params, Pagenation page) {
		return repository.selectByPage(params, page, "");
	}

	@Override
	public Integer insert(RoleMenu entry) {
		initEntry(entry);
		return repository.insert(entry);
	}

	@Override
	public Integer update(RoleMenu entry) {
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

	protected void initEntry(RoleMenu entry) {
		RoleMenu item = entry;
		Date d = new Date();
		item.setCreateTime(d);
		item.setUpdateTime(d);
		item.setUpdateUser(item.getCreateUser());
		item.setId(UUIDUtils.getUUID());
	}
}
