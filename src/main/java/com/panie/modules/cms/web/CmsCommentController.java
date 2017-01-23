package com.panie.modules.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.cms.entity.CmsComment;
import com.panie.modules.cms.service.CmsCommentService;

@Controller
@RequestMapping(value = "/cms/comment")
public class CmsCommentController extends BaseController<CmsComment>
{
    @Autowired
    private CmsCommentService cmsCommentService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<CmsComment> list(CmsComment entity)
    {
        List<CmsComment> list = cmsCommentService.findList(entity);
        return list;
    }
}