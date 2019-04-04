package com.learning.practice.controller;

import com.learning.practice.base.BaseController;
import com.learning.practice.base.IService;
import com.learning.practice.entity.UserRole;
import com.learning.practice.service.IUserRoleService;
import com.learning.practice.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author Kevin
 * <p>
 * try it,do it best!
 */

@Controller
@RequestMapping("/userRole/*")
public class UserRoleController extends BaseController<UserRole, String> {

    @Autowired
    private IUserRoleService service;

    @Override
    protected IService<UserRole, String> getService() {
        return service;
    }

    @Override
    protected String getTemplateFolder() {
        return "";
    }

    @RequestMapping("/saveUserRole")
    @ResponseBody
    public JsonResult saveRoleMenu(HttpServletRequest request) {
        Map params = request.getParameterMap();
        try {
            saveUserRole(params);
            return new JsonResult<>(true, JsonResult.SUCCESS);
        } catch (Exception e) {
            logger.error(e);
            return new JsonResult<>(false, JsonResult.FAILED);
        }
    }

    private Integer saveUserRole(Map parmas) {
        int count = 0;
        // 查出所以的撺掇
        String[] roles = (String[]) parmas.get("roles[]");
        List<UserRole> list = new ArrayList<>();
        String[] accounts = (String[]) parmas.get("account");
        for (int i = 0; i < roles.length; i++) {
            String account = accounts[0];
            String role = roles[i];
            int validate = service.validateUserRole(role, account);
            if (validate <= 0) {
                UserRole userRole = new UserRole();
                userRole.setAccount(account);
                userRole.setRoleNo(role);
                userRole.setStatus((short) 1);
                service.insert(userRole);
                count++;
            }
        }
        return count;
    }
}
