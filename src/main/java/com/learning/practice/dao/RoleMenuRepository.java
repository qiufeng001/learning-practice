package com.learning.practice.dao;

import com.learning.practice.entity.RoleMenu;
import com.learning.practice.base.IRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户接口
 */
@Mapper
public interface RoleMenuRepository extends IRepository<RoleMenu, String> {

    Integer validateRoleMenu(@Param("roleNo") String roleNo, @Param("menuId") String menuId);

}
