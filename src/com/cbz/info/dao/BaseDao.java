package com.cbz.info.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	
	public Object add(T t);
	
	public void del(T t);
	
	public void delAll(Collection<?> t);
	
	public void modify(T t);
	
	public T get(int id);
	
	public T load(int id);
	
	public int count();
	
	public void saveOrUpdate(T t);
	
	public List<T> findAll();
	
	public List<T> findAll(String orderby);
	
	public List<T> findAllForDesc(String orderby);
	
	public List<T> findAllForAsc(String orderby);
	
	public List<T> findAll(String hql, Object... params);
	
	public List<T> findAll(DetachedCriteria criteria);
	
	public List<T> findPage(int pageNo,int counts) ;
	
	public List<T> findPage(int pageNo,int counts,String orderby) ;
	
	public List<T> findPageForDesc(int pageNo,int counts,String orderby);
	
	public List<T> findPageForAsc(int pageNo,int counts,String orderby);
	
	public List<T> findPage(DetachedCriteria criteria,int pageNo,int counts);
	
	public List<T> findPage(String hql,int pageNo,int counts ,Object... params);
	

	
	
	
}
