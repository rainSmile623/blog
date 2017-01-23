package com.panie.common.entity;

import java.util.Date;

import com.panie.modules.sys.entity.SysUser;
import com.panie.modules.sys.utils.UserUtils;

/**
 * 数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity<T>
{
    
    private static final long serialVersionUID = 1L;
    
    private SysUser createBy; // 创建人
    
    private Date createDate; // 创建时间
    
    private SysUser updateBy; // 修改人
    
    private Date updateDate; // 修改时间
    
    private String remarks; // 备注信息
    
    private String delFlag; // 删除标记（0：正常；1：删除；）
    
    public DataEntity()
    {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }
    
    public SysUser getCreateBy()
    {
        return createBy;
    }
    
    public void setCreateBy(SysUser createBy)
    {
        this.createBy = createBy;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public SysUser getUpdateBy()
    {
        return updateBy;
    }
    
    public void setUpdateBy(SysUser updateBy)
    {
        this.updateBy = updateBy;
    }
    
    public Date getUpdateDate()
    {
        return updateDate;
    }
    
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }
    
    public String getRemarks()
    {
        return remarks;
    }
    
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
    
    public String getDelFlag()
    {
        return delFlag;
    }
    
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }
    
    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert()
    {
        SysUser user = UserUtils.getUser();
        if (user.getUserId() != null)
        {
            this.createBy = user;
            this.updateBy = user;
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }
    
    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate()
    {
        SysUser user = UserUtils.getUser();
        if (user.getUserId() != null)
        {
            this.updateBy = user;
        }
        this.updateDate = new Date();
    }
    
}
