package com.springmvc.service;

import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(Serializable id);

	/**
	 * 查询所有记录
	 * 
	 * @return
	 */
	public List<T> queryAll();

	/**
	 * 根据条件查询
	 * 
	 * @param t
	 * @return
	 */
	public List<T> queryListByWhere(T t);

	/**
	 * 根据条件查询记录总数
	 * @param t
	 * @return
	 */
	public long queryCountByWhere(T t);

	/**
	 * 根据条件查询
	 * @param example
	 * @return
	 */
	public List<T> queryListByExample(Example example);
	
	/**
	 * 分页查询记录
	 * 
	 * @param page 当前页号
	 * @param rows 页大小
	 * @return
	 */
	public List<T> queryListByPage(Integer page, Integer rows);

	/**
	 * 选择性新增
	 * 
	 * @param t
	 */
	public void saveSelective(T t);

	/**
	 * 根据id选择性更新
	 * 
	 * @param t
	 */
	public void updateSelectiveById(T t);

	/**
	 * 根据id删除
	 *
     * @param id
     */
	public void deleteById(Serializable id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void deleteByIds(Serializable[] ids);


	/*
	* amount of data generated today
	* */
	Integer countToday(String fromDate, String toDay);

}
