package com.panie.common.dao;

import java.util.List;

/**
 * DAO支持类实现
 * 
 * @param <T>
 */
public interface BaseDao<T>
{
    /**
     * 获取单条数据
     * 
     * @param entity
     * @return
     */
    public T get(T entity);
    
    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * 
     * @param entity
     * @return
     */
    public List<T> findList(T entity);
    
    /**
     * 查询所有数据列表
     * 
     * @param entity
     * @return
     */
    public List<T> findAllList(T entity);
    
    /**
     * 插入数据（每个字段都需要赋值）
     * 
     * @param entity
     * @return
     */
    public int insert(T entity);
    
    /**
     * 插入数据（只更新数据有值的字段，其他字段可以为空）
     * 
     * @param record
     * @return
     */
    public int insertSelective(T entity);
    
    /**
     * 更新数据（每个字段都需要赋值）
     * 
     * @param entity
     * @return
     */
    public int update(T entity);
    
    /**
     * 更新数据（只更新数据有值的字段，其他字段可以为空）
     * 
     * @param entity
     * @return
     */
    public int updateSelective(T entity);
    
    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * 
     * @param entity
     * @return
     */
    public int delete(T entity);
    
    /**
     * 批量删除
     * 
     * @param entity
     * @return
     */
    public int batchDelete(List<T> list);
    
    /**
     * 批量插入
     * 
     * @param entity
     * @return
     */
    public int batchInsert(List<T> list);
    
}