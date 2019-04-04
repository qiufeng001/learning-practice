package com.learning.practice.dao;

import com.learning.practice.entity.Role;
import com.learning.practice.base.IRepository;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户接口
 */
@Mapper
public interface RoleRepository extends IRepository<Role, String> {

}
