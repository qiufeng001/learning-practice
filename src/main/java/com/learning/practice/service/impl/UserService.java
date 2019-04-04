package com.learning.practice.service.impl;

import com.learning.practice.base.Pagenation;
import com.learning.practice.dao.UserRepository;
import com.learning.practice.entity.Role;
import com.learning.practice.entity.User;
import com.learning.practice.entity.UserRole;
import com.learning.practice.service.IUserService;
import com.learning.practice.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@SuppressWarnings("ALL")
@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User getByAccount(String account) {
		return repository.getByAccount(account);
	}

	@Override
	public List<Role> listByAccount(String account) {
		return repository.listByAccount(account);
	}

	@Override
	public Integer getOnlineNumber() {
		return repository.getOnlineNumber();
	}

	@Override
	public User findByParam(Map<String, Object> params) {
		return repository.findByParam(params);
	}

	@Override
	public User findByPrimaryKey(String id) {
		return repository.findByPrimaryKey(id);
	}

	@Override
	public Integer selectCount(Map<String, Object> params) {
		return repository.selectCount(params);
	}

	@Override
	public List<User> selectByPage(Map<String, Object> params, Pagenation page) {
		return repository.selectByPage(params, page, "");
	}

	@Override
	public Integer insert(User entry) {
		initEntry(entry);
		return repository.insert(entry);
	}

	@Override
	public Integer update(User entry) {
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

	protected void initEntry(User entry) {
		User item = entry;
		Date d = new Date();
		item.setCreateTime(d);
		item.setUpdateTime(d);
		item.setUpdateUser(item.getCreateUser());
		item.setId(UUIDUtils.getUUID());
	}
}
