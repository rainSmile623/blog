package com.panie.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.panie.common.entity.DataEntity;

public class SysUser extends DataEntity<SysUser>
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Integer userId;
    
    private String userLoginName;
    
    private String userPassword;
    
    private String userName;
    
    private String userCareer;
    
    private String userEmail;
    
    private String userPhone;
    
    private String userMobile;
    
    private String userType;
    
    private String userPhoto;
    
    private String userLoginIp;
    
    private Date userLoginDate;
    
    private String userLoginFlag; // 用户是否能登录
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public String getUserLoginName()
    {
        return userLoginName;
    }
    
    public void setUserLoginName(String userLoginName)
    {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }
    
    public String getUserPassword()
    {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName == null ? null : userName.trim();
    }
    
    public String getUserCareer()
    {
        return userCareer;
    }
    
    public void setUserCareer(String userCareer)
    {
        this.userCareer = userCareer == null ? null : userCareer.trim();
    }
    
    public String getUserEmail()
    {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }
    
    public String getUserPhone()
    {
        return userPhone;
    }
    
    public void setUserPhone(String userPhone)
    {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }
    
    public String getUserMobile()
    {
        return userMobile;
    }
    
    public void setUserMobile(String userMobile)
    {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType == null ? null : userType.trim();
    }
    
    public String getUserPhoto()
    {
        return userPhoto;
    }
    
    public void setUserPhoto(String userPhoto)
    {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }
    
    public String getUserLoginIp()
    {
        return userLoginIp;
    }
    
    public void setUserLoginIp(String userLoginIp)
    {
        this.userLoginIp = userLoginIp == null ? null : userLoginIp.trim();
    }
    
    public Date getUserLoginDate()
    {
        return userLoginDate;
    }
    
    public void setUserLoginDate(Date userLoginDate)
    {
        this.userLoginDate = userLoginDate;
    }
    
    public String getUserLoginFlag()
    {
        return userLoginFlag;
    }
    
    public void setUserLoginFlag(String userLoginFlag)
    {
        this.userLoginFlag = userLoginFlag == null ? null : userLoginFlag.trim();
    }
    
    @Override
    public Serializable getId()
    {
        return getUserId();
    }
}