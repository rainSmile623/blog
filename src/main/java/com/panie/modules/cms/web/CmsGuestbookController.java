package com.panie.modules.cms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panie.common.web.BaseController;
import com.panie.modules.cms.entity.CmsGuestbook;
import com.panie.modules.cms.service.CmsGuestbookService;

@Controller
@RequestMapping(value = "/cms/guestbook")
public class CmsGuestbookController extends BaseController<CmsGuestbook>
{
    @Autowired
    private CmsGuestbookService cmsGuestbookService;
    
    @RequestMapping(value = "list")
    @ResponseBody
    public List<CmsGuestbook> list(CmsGuestbook entity)
    {
        List<CmsGuestbook> list = cmsGuestbookService.findList(entity);
        return list;
    }
}