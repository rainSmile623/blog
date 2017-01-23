package com.panie.modules.cms.service;

import org.springframework.stereotype.Service;

import com.panie.common.service.BaseService;
import com.panie.modules.cms.dao.CmsArticleDataMapper;
import com.panie.modules.cms.entity.CmsArticleData;

@Service
public class CmsArticleDataService extends BaseService<CmsArticleDataMapper,CmsArticleData>
{    
    public int updateWithBLOBs(CmsArticleData record)
    {
        return dao.updateWithBLOBs(record);
    }
}