package com.panie.modules.sys.entity;

import java.io.Serializable;

import com.panie.common.entity.DataEntity;

public class SysMenu extends DataEntity<SysMenu>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer menuId;
    
    private String menuParentId;
    
    private String menuName;
    
    private Integer menuSort;
    
    private String menuHref;
    
    private String menuTarget;
    
    private String menuIcon;
    
    private String isShow;
    
    public Integer getMenuId()
    {
        return menuId;
    }
    
    public void setMenuId(Integer menuId)
    {
        this.menuId = menuId;
    }
    
    public String getMenuParentId()
    {
        return menuParentId;
    }
    
    public void setMenuParentId(String menuParentId)
    {
        this.menuParentId = menuParentId == null ? null : menuParentId.trim();
    }
    
    public String getMenuName()
    {
        return menuName;
    }
    
    public void setMenuName(String menuName)
    {
        this.menuName = menuName == null ? null : menuName.trim();
    }
    
    public Integer getMenuSort()
    {
        return menuSort;
    }
    
    public void setMenuSort(Integer menuSort)
    {
        this.menuSort = menuSort;
    }
    
    public String getMenuHref()
    {
        return menuHref;
    }
    
    public void setMenuHref(String menuHref)
    {
        this.menuHref = menuHref == null ? null : menuHref.trim();
    }
    
    public String getMenuTarget()
    {
        return menuTarget;
    }
    
    public void setMenuTarget(String menuTarget)
    {
        this.menuTarget = menuTarget == null ? null : menuTarget.trim();
    }
    
    public String getMenuIcon()
    {
        return menuIcon;
    }
    
    public void setMenuIcon(String menuIcon)
    {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
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
        return getMenuId();
    }
}