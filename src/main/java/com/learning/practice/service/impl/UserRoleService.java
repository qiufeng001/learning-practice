package com.learning.practice.service.impl;

import com.learning.practice.base.Pagenation;
import com.learning.practice.dao.UserRoleRepository;
import com.learning.practice.entity.Role;
import com.learning.practice.entity.UserRole;
import com.learning.practice.service.IUserRoleService;
import com.learning.practice.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class UserRoleService implements IUserRoleService {

	@Autowired
	private UserRoleRepository repository;

	@Override
	public Integer validateUserRole(String roleNo, String accound) {
		return repository.validateUserRole(roleNo, accound);
	}

	@Override
	public UserRole findByParam(Map<String, Object> params) {
		return repository.findByParam(params);
	}


	@Override
	public UserRole findByPrimaryKey(String id) {
		return repository.findByPrimaryKey(id);
	}

	@Override
	public Integer selectCount(Map<String, Object> params) {
		return repository.selectCount(params);
	}

	@Override
	public List<UserRole> selectByPage(Map<String, Object> params, Pagenation page) {
		return repository.selectByPage(params, page, "");
	}

	@Override
	public Integer insert(UserRole entry) {
		initEntry(entry);
		return repository.insert(entry);
	}

	@Override
	public Integer update(UserRole entry) {
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

	protected void initEntry(UserRole entry) {
		UserRole item = entry;
		Date d = new Date();
		item.setCreateTime(d);
		item.setUpdateTime(d);
		item.setUpdateUser(item.getCreateUser());
		item.setId(UUIDUtils.getUUID());
	}
}
