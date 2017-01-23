package com.panie.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.sys.entity.SysUser;
import com.panie.modules.sys.service.SysUserService;

@Controller
@RequestMapping(value = "/sys/user")
public class SysUserController extends BaseController<SysUser>
{
    @Autowired
    private SysUserService sysUserService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<SysUser> list(SysUser entity)
    {
        List<SysUser> list = sysUserService.findList(entity);
        return list;
    }
}