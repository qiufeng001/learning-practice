package com.learning.practice.controller;

import com.learning.practice.base.BaseController;
import com.learning.practice.base.Common;
import com.learning.practice.base.IService;
import com.learning.practice.entity.Menu;
import com.learning.practice.service.ICommonService;
import com.learning.practice.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
@RequestMapping("/menu/*")
public class MenuController extends BaseController<Menu, String> {

    @Autowired
    private IMenuService service;
    @Autowired
    private ICommonService commonManager;

    @Override
    protected IService<Menu, String> getService() {
        return service;
    }

    @Override
    protected String getTemplateFolder() {
        return "/admin/menu";
    }

    @RequestMapping("/selectPid")
    @ResponseBody
    public List<Menu> selectPid() {
        return service.selectPid();
    }

    @RequestMapping("/menuRole")
    @ResponseBody
    public Map<String, Object> menuRole() {
        Map<String, Object> map = new HashMap<>();

        map.put("kkk", "ja");
        return map;
    }

    /**
     * 编辑或者修改查询,跳转到编辑页面
     */
    @RequestMapping("/edit")
    public String edit(Model model, @RequestParam("id") String id) {
        Menu menu = new Menu();
        if (!StringUtils.isEmpty(id)) {
            menu = service.findByPrimaryKey(id);
        }
        model.addAttribute(menu);
        return "/admin/menu/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createOrUpdate")
    @ResponseBody
    public Menu createOrUpdate(Map<String, Object> params, Menu menu) {
        try {
            String id = menu.getId();
            if (StringUtils.isEmpty(id)) {
                // 新增
                if(menu.getPId() == null || menu.getPId().equalsIgnoreCase("")) {
                    menu.setPId("0");
                }
                service.insert(menu);
            } else {
                // 修改
                service.update(menu);
            }
        } catch (Exception e) {
            logger.error(e);
            // return new JsonResult(false, JsonResult.FAILED);
        }
        return menu;
    }

    @RequestMapping("/validate")
    @ResponseBody
    public Integer validate(Map<String, Object> params) {
       // Map<String, Object> map = query.asMap();
        //String type = (String)map.get("type");
        Integer count = 0;
        try {
            count = service.selectCount(params);
        }catch (Exception e) {
            logger.error(e);
        }
        return count;
    }

    @RequestMapping("/getSequence")
    @ResponseBody
    public Common getSequence(Map<String, Object> params) {
        params.put("tableName", "t_menu");
        Common wxCommon = commonManager.findMaxSequence(params);
        return wxCommon;
    }
}
