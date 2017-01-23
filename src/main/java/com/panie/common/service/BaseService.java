package com.panie.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.panie.common.dao.BaseDao;
import com.panie.common.entity.BaseEntity;

@Transactional(readOnly = true)
public abstract class BaseService<D extends BaseDao<T>, T extends BaseEntity<T>>
{
    
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;
    
    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity)
    {
        return dao.get(entity);
    }
    
    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<T> findList(T entity)
    {
        return dao.findList(entity);
    }
    
    public List<T> findAllList(T entity)
    {
        return dao.findAllList(entity);
    }
    
    /**
     * 查询分页数据
     * @param page 分页对象
     * @param entity
     * @return
     */
    public PageInfo<T> findPage(PageInfo<T> page, T entity)
    {
        page.setList(dao.findList(entity));
        return page;
    }
    
    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity)
    {
        if(entity.getIsNewRecord())
        {
            entity.preInsert();
            dao.insertSelective(entity);
        }
        else
        {
            entity.preUpdate();
            dao.updateSelective(entity);
        }
    }
    
    /**
     * 删除数据
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity)
    {
        dao.delete(entity);
    }
}
