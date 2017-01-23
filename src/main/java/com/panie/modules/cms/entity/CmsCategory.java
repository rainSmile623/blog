package com.panie.modules.cms.entity;

import java.io.Serializable;

import com.panie.common.entity.DataEntity;

public class CmsCategory extends DataEntity<CmsCategory>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer categoryId;
    
    private String categoryName;
    
    private String categoryDescription;
    
    private String categoryAllowComment;
    
    public Integer getCategoryId()
    {
        return categoryId;
    }
    
    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName()
    {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
    
    public String getCategoryDescription()
    {
        return categoryDescription;
    }
    
    public void setCategoryDescription(String categoryDescription)
    {
        this.categoryDescription = categoryDescription == null ? null : categoryDescription.trim();
    }
    
    public String getCategoryAllowComment()
    {
        return categoryAllowComment;
    }
    
    public void setCategoryAllowComment(String categoryAllowComment)
    {
        this.categoryAllowComment = categoryAllowComment == null ? null : categoryAllowComment.trim();
    }
    
    @Override
    public Serializable getId()
    {
        return getCategoryId();
    }
}