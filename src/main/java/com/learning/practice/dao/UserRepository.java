package com.learning.practice.dao;

import com.learning.practice.entity.Role;
import com.learning.practice.entity.User;
import com.learning.practice.base.IRepository;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 用户接口
 */
@Mapper
public interface UserRepository extends IRepository<User, String> {
    /*
     * 根据shiro中的账号用户登录信息，获取用户账号，再用账号获取用户信息
     * @return 用户对象
     */
    User getByAccount(String account);

    /**
     *  通过用户账号获取该账号的权限集合
     *
     * @return 角色集合
     */
    List<Role> listByAccount(String account);

    Integer getOnlineNumber();
}
