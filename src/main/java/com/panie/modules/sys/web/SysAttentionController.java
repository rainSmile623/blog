package com.panie.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.sys.entity.SysAttention;
import com.panie.modules.sys.service.SysAttentionService;

@Controller
@RequestMapping(value = "/sys/attention")
public class SysAttentionController extends BaseController<SysAttention>
{
    @Autowired
    private SysAttentionService sysAttentionService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<SysAttention> list(SysAttention entity)
    {
        List<SysAttention> list = sysAttentionService.findList(entity);
        return list;
    }
}