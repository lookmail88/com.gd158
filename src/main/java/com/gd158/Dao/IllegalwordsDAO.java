package com.gd158.Dao;

import java.util.List;

import com.gd158.Entity.DataBaseMapping.TSysIllegalkeywords;



public interface IllegalwordsDAO extends IGenericDAO<TSysIllegalkeywords>{

	public List findALLByJDBC();
	public List findALLByHibernate();
	public List findBySpringHibernate();

}
