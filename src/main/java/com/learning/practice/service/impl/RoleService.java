package com.learning.practice.service.impl;

import com.learning.practice.base.IRepository;
import com.learning.practice.base.Pagenation;
import com.learning.practice.dao.RoleRepository;
import com.learning.practice.entity.Role;
import com.learning.practice.entity.RoleMenu;
import com.learning.practice.service.IRoleService;
import com.learning.practice.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	public Role findByPrimaryKey(String id) {
		return repository.findByPrimaryKey(id);
	}

	@Override
	public Role findByParam(Map<String, Object> params) {
		return repository.findByParam(params);
	}


	@Override
	public Integer selectCount(Map<String, Object> params) {
		return repository.selectCount(params);
	}

	@Override
	public List<Role> selectByPage(Map<String, Object> params, Pagenation page) {
		return repository.selectByPage(params, page, "");
	}

	@Override
	public Integer insert(Role entry) {
		initEntry(entry);
		return repository.insert(entry);
	}

	@Override
	public Integer update(Role entry) {
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

	protected void initEntry(Role entry) {
		Role item = entry;
		Date d = new Date();
		item.setCreateTime(d);
		item.setUpdateTime(d);
		item.setUpdateUser(item.getCreateUser());
		item.setId(UUIDUtils.getUUID());
	}
}
