package com.learning.practice.dao;

import com.learning.practice.entity.UserRole;
import com.learning.practice.base.IRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户接口
 */
@Mapper
public interface UserRoleRepository extends IRepository<UserRole, String> {

    Integer validateUserRole(@Param("roleNo") String roleNo, @Param("account") String account);
}
