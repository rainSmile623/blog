package com.panie.modules.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.cms.entity.CmsArticleData;
import com.panie.modules.cms.service.CmsArticleDataService;

@Controller
@RequestMapping(value = "/cms/articledata")
public class CmsArticleDataController extends BaseController<CmsArticleData>
{    
    @Autowired
    private CmsArticleDataService cmsArticleDataService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<CmsArticleData> list(CmsArticleData data)
    {
        List<CmsArticleData> list = cmsArticleDataService.findList(data);
        return list;
    }
}