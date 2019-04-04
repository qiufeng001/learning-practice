package com.learning.practice.controller;

import com.learning.practice.base.BaseController;
import com.learning.practice.base.IService;
import com.learning.practice.entity.User;
import com.learning.practice.service.IUserService;
import com.learning.practice.utils.DESUtils;
import com.learning.practice.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;



/*
 * 这个是用于维护用户信息的类
 * 
 * @author zhong.h
 *	
 * try it,do it best!
 */

@Controller
@RequestMapping("/user/*")
public class UserController extends BaseController<User, String> {

    @Autowired
    private IUserService service;

    @Override
    protected IService<User, String> getService() {
        return service;
    }

    @Override
    protected String getTemplateFolder() {
        return "/admin/user";
    }

    /**
     * 编辑或者修改查询,跳转到编辑页面
     */
    @RequestMapping("/edit")
    public String edit(Model model, @RequestParam("id") String id) {
        User user = new User();
        if (!StringUtils.isEmpty(id)) {
            user = service.findByPrimaryKey(id);
        }
        model.addAttribute(user);
        return "/admin/user/edit";
    }

    @RequestMapping("/createOrUpdate")
    @ResponseBody
    public JsonResult createOrUpdate(User user) {
        try {
            int count = validate(user);
            if(count <= 0) {
                String id = (String) user.getId();
                if (StringUtils.isEmpty(id)) {
                    // 新增
                    // 默认密码
                    String pwd = "0000";
                    String encrytor = DESUtils.jdkBase64String(DESUtils.encrytor(pwd, "sdn_ddos"));
                    user.setPassword(encrytor);
                    service.insert(user);
                } else {
                    // 修改
                    service.update(user);
                }
            }else {
                return new JsonResult(false,  "repeat");
            }
        } catch (Exception e) {
            logger.error(e);
            return new JsonResult(false, JsonResult.FAILED);
        }
        return new JsonResult(true, JsonResult.SUCCESS);
    }

    /**
     * 修改密码跳转
     */
    @RequestMapping(value = "/editPwd")
    @ResponseBody
    public JsonResult editPwd(Model model) {
        String userId =  "";
        return new JsonResult(true, userId);
    }

    /**
     *  密码修改后保存
     * @param user
     * @return
     */
    @RequestMapping(value = "/updatePwd")
    @ResponseBody
    public JsonResult updatePwd(User user) {
        try {
            // 密码使用 des 加密
            String password = user.getPassword();
            user = service.findByPrimaryKey(user.getId());
            user.setPassword(DESUtils.jdkBase64String(DESUtils.encrytor(password, "sdn_ddos")));
            service.update(user);
        }catch (Exception e) {
            logger.error(e);
        }
        // 修改密码后强制重新登录
        return new JsonResult(true, JsonResult.SUCCESS);
    }

    private Integer validate(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name",user.getName());
        params.put("account",user.getAccount());
        Integer count = 0;
        try {
            count = service.validate(params);
        }catch (Exception e) {
            logger.error(e);
        }
        return count;
    }
}
