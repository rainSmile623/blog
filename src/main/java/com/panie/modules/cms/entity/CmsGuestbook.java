package com.panie.modules.cms.entity;

import java.util.Date;

import com.panie.common.entity.DataEntity;

public class CmsGuestbook extends DataEntity<CmsGuestbook>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String type;
    
    private String content;
    
    private String name;
    
    private String email;
    
    private String phone;
    
    private String workunit;
    
    private String ip;
    
    private Date createDate;
    
    private String reUserId;
    
    private Date reDate;
    
    private String reContent;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type == null ? null : type.trim();
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email == null ? null : email.trim();
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone == null ? null : phone.trim();
    }
    
    public String getWorkunit()
    {
        return workunit;
    }
    
    public void setWorkunit(String workunit)
    {
        this.workunit = workunit == null ? null : workunit.trim();
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip == null ? null : ip.trim();
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public String getReUserId()
    {
        return reUserId;
    }
    
    public void setReUserId(String reUserId)
    {
        this.reUserId = reUserId == null ? null : reUserId.trim();
    }
    
    public Date getReDate()
    {
        return reDate;
    }
    
    public void setReDate(Date reDate)
    {
        this.reDate = reDate;
    }
    
    public String getReContent()
    {
        return reContent;
    }
    
    public void setReContent(String reContent)
    {
        this.reContent = reContent == null ? null : reContent.trim();
    }
}