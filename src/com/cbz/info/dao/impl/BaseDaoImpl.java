package com.cbz.info.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cbz.info.dao.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{

	@Resource
	protected HibernateTemplate hibernateTemplate;
	
	protected Class<T> entityClazz;
	
	protected String primaryKey ;
	
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();  
		if (type instanceof ParameterizedType) {  
            this.entityClazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];  
        } else {  
            this.entityClazz = null;  
        }  
		Field[] fields = entityClazz.getFields();
		for (Field field : fields) {
			if(field.isAnnotationPresent(Id.class)){
				this.primaryKey = field.getName();
			}
		}
	}

	@Override
	public Object add(T t) {
		return hibernateTemplate.save(t);
	}

	@Override
	public void del(T t) {
		hibernateTemplate.delete(t);
	}

	@Override
	public void modify(T t) {
		hibernateTemplate.update(t);
	}

	@Override
	public T get(int id) {
		return hibernateTemplate.get(entityClazz, id);
	}

	@Override
	public T load(int id){
		return hibernateTemplate.load(entityClazz, id);
	}
	
	@Override
	public List<T> findAll(String hql,Object... params) {
		return (List<T>) hibernateTemplate.find(hql,params);
	}

	@Override
	public List<T> findPage(int pageNo, int counts) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClazz);
		return (List<T>) hibernateTemplate.findByCriteria(criteria,(pageNo-1)*counts,counts);
	}

	@Override
	public void delAll(Collection<?> t) {
		 hibernateTemplate.deleteAll(t);
	}

	@Override
	public List<T> findAll() {
		return (List<T>) hibernateTemplate.find("from " + entityClazz.getSimpleName());
	}

	@Override
	public List<T> findAllForDesc(String orderby) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClazz);
		criteria.addOrder(Order.desc(orderby));
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<T> findAllForAsc(String orderby) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClazz);
		criteria.addOrder(Order.asc(orderby));
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<T> findAll(DetachedCriteria criteria) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}

	
	@Override
	public List<T> findPageForDesc(int pageNo, int counts, String orderby) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClazz);
		criteria.addOrder(Order.desc(orderby));
		return (List<T>) hibernateTemplate.findByCriteria(criteria,(pageNo-1)*counts,counts);
	}

	@Override
	public List<T> findPageForAsc(int pageNo, int counts, String orderby) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClazz);
		criteria.addOrder(Order.asc(orderby));
		return (List<T>) hibernateTemplate.findByCriteria(criteria,(pageNo-1)*counts,counts);
	}

	@Override
	public List<T> findPage(DetachedCriteria criteria, int pageNo, int counts) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria,(pageNo-1)*counts,counts);
	}

	@Override
	public List<T> findPage(String hql, int pageNo, int counts, Object... params) {
		List<T> execute = (List<T>) hibernateTemplate.execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session arg0) throws HibernateException {
					Query query = arg0.createQuery(hql);
					for (int i=0, len = params.length;i<len;i++) {
						query.setParameter(i, params[i]);
					}
		            query.setFirstResult((pageNo-1)*counts);
		            query.setMaxResults(counts);
		            List<T> list = query.list();
		            return (T) list;
			}
		});
		return execute;
	}

	@Override
	public int count() {
		return (int) hibernateTemplate.find("select count(*) from " + entityClazz.getSimpleName()).get(0);
	}

	@Override
	public void saveOrUpdate(T t) {
		 hibernateTemplate.saveOrUpdate(t);
	}

	@Override
	public List<T> findAll(String orderby) {
		return (List<T>) hibernateTemplate.find("from " + entityClazz + " order by " + primaryKey + " " + orderby);
	}

	@Override
	public List<T> findPage(int pageNo, int counts, String orderby) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClazz);
		if("asc".equalsIgnoreCase(orderby)){
			criteria.addOrder(Order.asc(primaryKey));
		} else if ("desc".equalsIgnoreCase(orderby)){
			criteria.addOrder(Order.desc(primaryKey));
		}
		return (List<T>) hibernateTemplate.findByCriteria(criteria,(pageNo-1)*counts,counts);
	}


}
