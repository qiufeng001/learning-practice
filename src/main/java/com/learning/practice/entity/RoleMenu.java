package com.learning.practice.entity;

import com.learning.practice.base.BaseEntity;

/**
 *
 * @author zhong.h
 */
public class RoleMenu extends BaseEntity<String> {
    private String roleNo;
    private String menuId;

    public String getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
