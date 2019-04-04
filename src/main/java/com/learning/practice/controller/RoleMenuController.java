package com.learning.practice.controller;

import com.learning.practice.base.BaseController;
import com.learning.practice.base.IService;
import com.learning.practice.entity.RoleMenu;
import com.learning.practice.service.IRoleMenuService;
import com.learning.practice.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * 这个是用于维护用户信息的类
 *
 * @author zhong.h
 *
 * try it,do it best!
 */

@Controller
@RequestMapping("/roleMenu/*")
public class RoleMenuController extends BaseController<RoleMenu, String> {

    @Autowired
    private IRoleMenuService service;

    @Override
    protected IService<RoleMenu, String> getService() {
        return service;
    }

    @RequestMapping(value = "/index")
    public String index1() {
        return getTemplateFolder() + "/index";
    }

    @Override
    protected String getTemplateFolder() {
        return "/admin/role";
    }

    @RequestMapping("/saveRoleMenu")
    @ResponseBody
    public JsonResult saveRoleMenu(HttpServletRequest request) {
        Map params = request.getParameterMap();
        try {
            saveRoleMenu(params);
            return new JsonResult<>(true, JsonResult.SUCCESS);
        } catch (Exception e) {
            logger.error(e);
            return new JsonResult<>(false, JsonResult.FAILED);
        }
    }

    private Integer saveRoleMenu(Map parmas) {
        int count = 0;
        // 查出所以的撺掇
        String[] roles = (String[]) parmas.get("roles[]");
        List<RoleMenu> list = new ArrayList<>();
        String[] menuIds = (String[]) parmas.get("menuId");
        for (int i = 0; i < roles.length; i++) {
            String menuId = menuIds[0];
            String role = roles[i];
            int validate = service.validateRoleMenu(role, menuId);
            if (validate <= 0) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(menuId);
                roleMenu.setRoleNo(role);
                service.insert(roleMenu);
                count++;
            }
        }
        return count;

    }
}
