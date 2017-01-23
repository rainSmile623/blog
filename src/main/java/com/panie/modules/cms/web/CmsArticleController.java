package com.panie.modules.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.cms.entity.CmsArticle;
import com.panie.modules.cms.service.CmsArticleService;

@Controller
@RequestMapping(value = "/cms/article")
public class CmsArticleController extends BaseController<CmsArticle>
{
    @Autowired
    private CmsArticleService cmsArticleService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<CmsArticle> list(CmsArticle article)
    {
        List<CmsArticle> list = cmsArticleService.findList(article);
        return list;
    }
}