package com.panie.modules.sys.entity;

import java.io.Serializable;

import com.panie.common.entity.DataEntity;

/**
 * 标签云
 * 
 * @author ppnie
 */
public class SysLabel extends DataEntity<SysLabel>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer labelId;
    
    private String labelName;
    
    private Integer labelSort;
    
    private String labelColor;
    
    private String isShow;
    
    public Integer getLabelId()
    {
        return labelId;
    }
    
    public void setLabelId(Integer labelId)
    {
        this.labelId = labelId;
    }
    
    public String getLabelName()
    {
        return labelName;
    }
    
    public void setLabelName(String labelName)
    {
        this.labelName = labelName == null ? null : labelName.trim();
    }
    
    public Integer getLabelSort()
    {
        return labelSort;
    }
    
    public void setLabelSort(Integer labelSort)
    {
        this.labelSort = labelSort;
    }
    
    public String getLabelColor()
    {
        return labelColor;
    }
    
    public void setLabelColor(String labelColor)
    {
        this.labelColor = labelColor == null ? null : labelColor.trim();
    }
    
    public String getIsShow()
    {
        return isShow;
    }
    
    public void setIsShow(String isShow)
    {
        this.isShow = isShow == null ? null : isShow.trim();
    }
    
    @Override
    public Serializable getId()
    {
        return getLabelId();
    }
}