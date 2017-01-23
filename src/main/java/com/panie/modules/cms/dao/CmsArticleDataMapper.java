package com.panie.modules.cms.dao;

import com.panie.common.dao.BaseDao;
import com.panie.modules.cms.entity.CmsArticleData;

public interface CmsArticleDataMapper extends BaseDao<CmsArticleData>
{    
    int updateWithBLOBs(CmsArticleData record);
}