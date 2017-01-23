package com.panie.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;

import com.panie.common.entity.DataEntity;

/**
 * 文章信息
 * 
 * @author ppnie
 */
public class CmsArticle extends DataEntity<CmsArticle>
{
    /**
     * 
     */
    private static final long serialVersionUID = -7232405511783011763L;
    
    private Integer articleId;
    
    private CmsCategory category;
    
    private String articleTitle;
    
    private String articleLink;
    
    private String articleColor;
    
    private String articleImage;
    
    private String articleKeywords;
    
    private String articleDesc;
    
    private Integer articleWeight;
    
    private Date articleWeightDate;
    
    private Integer comments;
    
    private Integer hits;
    
    public Integer getArticleId()
    {
        return articleId;
    }
    
    public void setArticleId(Integer articleId)
    {
        this.articleId = articleId;
    }
    
    public CmsCategory getCategory()
    {
        return category;
    }
    
    public void setCategory(CmsCategory category)
    {
        this.category = category;
    }
    
    public String getArticleTitle()
    {
        return articleTitle;
    }
    
    public void setArticleTitle(String articleTitle)
    {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }
    
    public String getArticleLink()
    {
        return articleLink;
    }
    
    public void setArticleLink(String articleLink)
    {
        this.articleLink = articleLink == null ? null : articleLink.trim();
    }
    
    public String getArticleColor()
    {
        return articleColor;
    }
    
    public void setArticleColor(String articleColor)
    {
        this.articleColor = articleColor == null ? null : articleColor.trim();
    }
    
    public String getArticleImage()
    {
        return articleImage;
    }
    
    public void setArticleImage(String articleImage)
    {
        this.articleImage = articleImage == null ? null : articleImage.trim();
    }
    
    public String getArticleKeywords()
    {
        return articleKeywords;
    }
    
    public void setArticleKeywords(String articleKeywords)
    {
        this.articleKeywords = articleKeywords == null ? null : articleKeywords.trim();
    }
    
    public String getArticleDesc()
    {
        return articleDesc;
    }
    
    public void setArticleDesc(String articleDesc)
    {
        this.articleDesc = articleDesc == null ? null : articleDesc.trim();
    }
    
    public Integer getArticleWeight()
    {
        return articleWeight;
    }
    
    public void setArticleWeight(Integer articleWeight)
    {
        this.articleWeight = articleWeight;
    }
    
    public Date getArticleWeightDate()
    {
        return articleWeightDate;
    }
    
    public void setArticleWeightDate(Date articleWeightDate)
    {
        this.articleWeightDate = articleWeightDate;
    }
    
    public Integer getComments()
    {
        return comments;
    }
    
    public void setComments(Integer comments)
    {
        this.comments = comments;
    }
    
    public Integer getHits()
    {
        return hits;
    }
    
    public void setHits(Integer hits)
    {
        this.hits = hits;
    }
    
    @Override
    public Serializable getId()
    {
        return getArticleId();
    }
}