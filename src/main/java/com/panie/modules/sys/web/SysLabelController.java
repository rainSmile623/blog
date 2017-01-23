package com.panie.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.sys.entity.SysLabel;
import com.panie.modules.sys.service.SysLabelService;

@Controller
@RequestMapping(value = "/sys/label")
public class SysLabelController extends BaseController<SysLabel>
{
    @Autowired
    private SysLabelService sysLabelService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<SysLabel> list(SysLabel entity)
    {
        List<SysLabel> list = sysLabelService.findList(entity);
        return list;
    }
}