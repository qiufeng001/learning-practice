package com.learning.practice.controller;

import com.learning.practice.entity.User;
import com.learning.practice.service.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录维护类
 *
 * @author Kevin
 * <p>
 * try it,do it best!
 */
@SuppressWarnings("ALL")
@Controller
public class LoginController {

    protected Log log = LogFactory.getLog(getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login")
    public String index() {
        return "/admin/login";
    }

    @RequestMapping(value = "/")
    public String string() {
        return "/admin/login";
    }

    /**
     * 登录验证
     *
     */
    @RequestMapping(value = "/signin")
    @ResponseBody
    public int login(Map<String, Object> params, String account, String password) throws Exception {
        User findUser = getUser(params, account, password);
        // 用户名或者密码错误
        if (findUser == null) {
            return -1;
        }
        // 无效用户
        if (findUser.getStatus() == 0) {
            return 0;
        }
        return 1;
    }

    @RequestMapping(value = "/admin/home")
    public String home() {
        return "/common/index";
    }

    @RequestMapping("/signout")
    public String redirect(HttpServletRequest request) {
        return "redirect:/";
    }

    private User getUser(Map<String, Object> params, String account, String password) {
        params.put("account", account);
        params.put("password", password);
        return userService.findByParam(params);
    }
}
