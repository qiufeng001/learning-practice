package com.learning.practice.service;

import com.learning.practice.entity.UserRole;
import com.learning.practice.base.IService;


public interface IUserRoleService extends IService<UserRole, String> {

    /**
     * 在给菜单分配权限的时候，如果这个角色的菜单权限存在，则不插入
     * @param roleNo
     * @return
     */
    Integer validateUserRole(String roleNo, String accound);
}
