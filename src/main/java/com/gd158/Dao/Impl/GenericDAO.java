package com.gd158.Dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gd158.Dao.IGenericDAO;

public abstract class GenericDAO<T> implements IGenericDAO<T>{

	private Class<T> entityClass;  
	  
    public GenericDAO(Class<T> clazz) {  
        this.entityClass = clazz;  
    }  
  
    @Autowired  
    private SessionFactory sessionFactory;  
  
    @Override  
    public void insert(T t) {  
        sessionFactory.getCurrentSession().save(t);  
    }  
  
    @Override  
    public void delete(T t) {  
        sessionFactory.getCurrentSession().delete(t);  
    }  
  
    @Override  
    public void update(T t) {  
        sessionFactory.getCurrentSession().update(t);  
    }  
  
    @SuppressWarnings("unchecked")  
    @Override  
    public T queryById(String id) {  
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);  
    }  
  
    @Override  
    public List<T> queryAll() {  
        String hql = "from " + entityClass.getSimpleName();  
        return queryForList(hql, null);  
    }  
    
    
    @Override  
    public List<T> queryPage(String pageno,String pagesize){
    	int items=(Integer.parseInt(pageno)-1)*Integer.parseInt(pagesize)+1;
    	String hql = "from " + entityClass.getSimpleName(); 
    	org.hibernate.Query query = (org.hibernate.Query) sessionFactory.getCurrentSession().createQuery(hql);  
        
        query.setFirstResult(items);//定义从第几条开始查询  
        query.setMaxResults(Integer.parseInt(pagesize));//定义返回的记录数  
          
        List list = query.list();  
    	return queryForList(hql,null);  
    }
  
    @SuppressWarnings("unchecked")  
    protected T queryForObject(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return (T) query.uniqueResult();  
    }  
  
    @SuppressWarnings("unchecked")  
    protected T queryForTopObject(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();  
    }  
  
    @SuppressWarnings("unchecked")  
    protected List<T> queryForList(String hql, Object[] params) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return query.list();  
    }  
  
    @SuppressWarnings("unchecked")  
    protected List<T> queryForList(final String hql, final Object[] params,  
            final int recordNum) {  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        setQueryParams(query, params);  
        return query.setFirstResult(0).setMaxResults(recordNum).list();  
    }  
  
    private void setQueryParams(Query query, Object[] params) {  
        if (null == params) {  
            return;  
        }  
        for (int i = 0; i < params.length; i++) {  
            query.setParameter(i, params[i]);  
        }  
    }  

}
