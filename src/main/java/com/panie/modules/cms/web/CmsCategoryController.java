package com.panie.modules.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.cms.entity.CmsCategory;
import com.panie.modules.cms.service.CmsCategoryService;

@Controller
@RequestMapping(value = "/cms/category")
public class CmsCategoryController extends BaseController<CmsCategory>
{
    @Autowired
    private CmsCategoryService cmsCategoryService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<CmsCategory> list(CmsCategory entity)
    {
        List<CmsCategory> list = cmsCategoryService.findList(entity);
        return list;
    }
}