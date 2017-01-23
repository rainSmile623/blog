package com.panie.common.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.panie.modules.sys.entity.SysUser;
import com.panie.modules.sys.utils.UserUtils;

/**
 * Entity支持类
 */
public abstract class BaseEntity<T> implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    /**
     * 实体编号（唯一标识）
     */
    protected Serializable id;
    
    /**
     * 当前用户
     */
    protected SysUser currentUser;
    
    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;
    
    public BaseEntity()
    {
        
    }
    
    /**
     * 必须在子类中实现该接口
     * 根据该值来比较子类的两个对象是否相同
     * @return
     */
    public abstract Serializable getId();
    
    public void setId(Serializable id)
    {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        
        if (obj == null)
        {
            return false;
        }
        
        if (this == obj)
        {
            return true;
        }
        
        if (!(getClass().equals(obj.getClass())))
        {
            return false;
        }
        BaseEntity other = (BaseEntity)obj;
        Serializable id = getId();
        Serializable otherId = other.getId();
        if (id == null && otherId == null)
        {
            return true;
        }
        if (id == null || otherId == null)
        {
            return false;
        }
        return id.equals(otherId);
    }
    
    @Override
    public int hashCode()
    {
        int hasCode = 17;
        Serializable id = getId();
        hasCode = hasCode + (id == null ? 0 : id.hashCode());
        return hasCode;
    }
    
    @XmlTransient
    public SysUser getCurrentUser()
    {
        if (currentUser == null)
        {
            currentUser = UserUtils.getUser();
        }
        return currentUser;
    }
    
    public void setCurrentUser(SysUser currentUser)
    {
        this.currentUser = currentUser;
    }
    
    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
    
    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     * @return
     */
    public boolean getIsNewRecord()
    {
        return isNewRecord || getId() == null;
    }
    
    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    public void setIsNewRecord(boolean isNewRecord)
    {
        this.isNewRecord = isNewRecord;
    }
    
    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();
    
    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();
    
    /**
     * 删除标记（0：正常；1：删除；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    
}
