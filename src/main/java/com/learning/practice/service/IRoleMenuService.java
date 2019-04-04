package com.learning.practice.service;

import com.learning.practice.entity.RoleMenu;
import com.learning.practice.base.IService;

public interface IRoleMenuService extends IService<RoleMenu, String> {

    /**
     * 在给菜单分配权限的时候，如果这个角色的菜单权限存在，则不插入
     * @param roleNo
     * @param menuId
     * @return
     */
    Integer validateRoleMenu(String roleNo, String menuId);
}
