package com.learning.practice.service.impl;

import com.learning.practice.base.Common;
import com.learning.practice.base.Pagenation;
import com.learning.practice.dao.CommonRepository;
import com.learning.practice.entity.User;
import com.learning.practice.entity.UserRole;
import com.learning.practice.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class CommonService implements ICommonService {

	@Autowired
	private CommonRepository repository;


	@Override
	public Common findMaxSequence(Map<String, Object> params) {
		return repository.findMaxSequence(params);
	}

	@Override
	public Common findByParam(Map<String, Object> params) {
		return repository.findByParam(params);
	}

	@Override
	public Integer selectCount(Map<String, Object> params) {
		return null;
	}

	@Override
	public List<Common> selectByPage(Map<String, Object> params, Pagenation page) {
		return null;
	}

	@Override
	public Integer insert(Common entry) {
		return null;
	}

	@Override
	public Integer update(Common entry) {
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(String id) {
		return null;
	}

	@Override
	public Integer validate(Map<String, Object> params) {
		return null;
	}

	@Override
	public Common findByPrimaryKey(String id) {
		return repository.findByPrimaryKey(id);
	}
}
