package com.panie.modules.cms.entity;

import java.io.Serializable;

import com.panie.common.entity.DataEntity;

/**
 * 文章内容详情
 * @author ppnie
 *
 */
public class CmsArticleData extends DataEntity<CmsArticleData>
{
    /**
     * 
     */
    private static final long serialVersionUID = -8429425248267823688L;
    
    private Integer contentId;
    
    private CmsArticle article;
    
    private String contentCopyfrom;
    
    private String contentRelation;
    
    private String allowComment;
    
    private String contentData;
    
    public Integer getContentId()
    {
        return contentId;
    }
    
    public void setContentId(Integer contentId)
    {
        this.contentId = contentId;
    }    
    
    public CmsArticle getArticle()
    {
        return article;
    }

    public void setArticle(CmsArticle article)
    {
        this.article = article;
    }

    public String getContentCopyfrom()
    {
        return contentCopyfrom;
    }
    
    public void setContentCopyfrom(String contentCopyfrom)
    {
        this.contentCopyfrom = contentCopyfrom == null ? null : contentCopyfrom.trim();
    }
    
    public String getContentRelation()
    {
        return contentRelation;
    }
    
    public void setContentRelation(String contentRelation)
    {
        this.contentRelation = contentRelation == null ? null : contentRelation.trim();
    }
    
    public String getAllowComment()
    {
        return allowComment;
    }
    
    public void setAllowComment(String allowComment)
    {
        this.allowComment = allowComment == null ? null : allowComment.trim();
    }
    
    public String getContentData()
    {
        return contentData;
    }
    
    public void setContentData(String contentData)
    {
        this.contentData = contentData == null ? null : contentData.trim();
    }
    
    @Override
    public Serializable getId()
    {
        return getContentId();
    }
}