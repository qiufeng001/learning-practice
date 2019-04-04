package com.learning.practice.controller;

import com.learning.practice.base.BaseController;
import com.learning.practice.base.IService;
import com.learning.practice.entity.Role;
import com.learning.practice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Kevin
 *         <p>
 *         try it,do it best!
 */
@Controller
@RequestMapping("/role/*")
public class RoleController extends BaseController<Role, String> {

    @Autowired
    private IRoleService service;

    @Override
    protected IService<Role, String> getService() {
        return service;
    }

    @Override
    protected String getTemplateFolder() {
        return "/admin/role";
    }
}
