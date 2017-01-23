package com.panie.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;

import com.panie.common.entity.DataEntity;

public class CmsComment extends DataEntity<CmsComment>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer commentId;
    
    private CmsCategory category;
    
    private CmsArticleData articleData;
    
    private String commentTitle;
    
    private String commentContent;
    
    private String commentName;
    
    private String commentIp;
    
    private Date createDate;
    
    public Integer getCommentId()
    {
        return commentId;
    }
    
    public void setCommentId(Integer commentId)
    {
        this.commentId = commentId;
    }
    
    public CmsCategory getCategory()
    {
        return category;
    }
    
    public void setCategory(CmsCategory category)
    {
        this.category = category;
    }
    
    public CmsArticleData getArticleData()
    {
        return articleData;
    }
    
    public void setArticleData(CmsArticleData articleData)
    {
        this.articleData = articleData;
    }
    
    public String getCommentTitle()
    {
        return commentTitle;
    }
    
    public void setCommentTitle(String commentTitle)
    {
        this.commentTitle = commentTitle == null ? null : commentTitle.trim();
    }
    
    public String getCommentContent()
    {
        return commentContent;
    }
    
    public void setCommentContent(String commentContent)
    {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
    
    public String getCommentName()
    {
        return commentName;
    }
    
    public void setCommentName(String commentName)
    {
        this.commentName = commentName == null ? null : commentName.trim();
    }
    
    public String getCommentIp()
    {
        return commentIp;
    }
    
    public void setCommentIp(String commentIp)
    {
        this.commentIp = commentIp == null ? null : commentIp.trim();
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    @Override
    public Serializable getId()
    {
        // TODO Auto-generated method stub
        return getCommentId();
    }
}