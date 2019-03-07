package com.springmvc.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import com.springmvc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private Class<T> clazz;

	public BaseServiceImpl(){
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();

		this.clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}

	//泛型依赖注入；在spring 4.x版本可以根据泛型找到对应的业务dao对象；必须使用@Autowired
	@Autowired
	private Mapper<T> mapper;

	@Override
	public T queryById(Serializable id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> queryAll() {
		return mapper.selectAll();
	}

	@Override
	public List<T> queryListByWhere(T t) {
		return mapper.select(t);
	}

	@Override
	public long queryCountByWhere(T t) {
		return mapper.selectCount(t);
	}

	@Override
	public List<T> queryListByPage(Integer page, Integer rows) {
		//设置分页
		PageHelper.startPage(page, rows);

		return mapper.select(null);
	}

	@Override
	public List<T> queryListByExample(Example example) {
		return mapper.selectByExample(example);
	};

	@Override
	public void saveSelective(T t) {
		mapper.insertSelective(t);
	}

	@Override
	public void updateSelectiveById(T t) {
		mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Serializable id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Serializable[] ids) {
		Example example = new Example(this.clazz);

		//设置删除的id集合
		example.createCriteria().andIn("id", Arrays.asList(ids));

		mapper.deleteByExample(example);
	}

	public Integer countToday(String fromDate, String toDay) {
		return 0;
	}

}
