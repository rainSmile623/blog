package com.panie.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.sys.entity.SysMenu;
import com.panie.modules.sys.service.SysMenuService;

@Controller
@RequestMapping(value = "/sys/menu")
public class SysMenuController extends BaseController<SysMenu>
{
    @Autowired
    private SysMenuService sysMenuService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<SysMenu> list(SysMenu entity)
    {
        List<SysMenu> list = sysMenuService.findList(entity);
        return list;
    }
}