package com.panie.modules.sys.entity;

import java.io.Serializable;

import com.panie.common.entity.DataEntity;

public class SysAttention extends DataEntity<SysAttention>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer attentionId;
    
    private String attentionName;
    
    private String attentionHref;
    
    public Integer getAttentionId()
    {
        return attentionId;
    }
    
    public void setAttentionId(Integer attentionId)
    {
        this.attentionId = attentionId;
    }
    
    public String getAttentionName()
    {
        return attentionName;
    }
    
    public void setAttentionName(String attentionName)
    {
        this.attentionName = attentionName == null ? null : attentionName.trim();
    }
    
    public String getAttentionHref()
    {
        return attentionHref;
    }
    
    public void setAttentionHref(String attentionHref)
    {
        this.attentionHref = attentionHref == null ? null : attentionHref.trim();
    }
    
    @Override
    public Serializable getId()
    {
        return getAttentionId();
    }
}