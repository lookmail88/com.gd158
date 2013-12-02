package com.gd158.Services.Impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd158.Dao.IllegalwordsDAO;
import com.gd158.Services.Illegalkeywords;
import com.gd158.Entity.DataBaseMapping.TSysIllegalkeywords;

@Service("illegalkeywordsServices")
@Transactional
public class IllegalkeywordsImpl  implements Illegalkeywords{

	IllegalwordsDAO illegalwordsDao;

	public IllegalwordsDAO getIllegalwordsDao() {
		return illegalwordsDao;
	}

	public void setIllegalwordsDao(IllegalwordsDAO illegalwordsDao) {
		this.illegalwordsDao = illegalwordsDao;
	}

	@Override
	public String add(String keywords) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String del(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllbyJDBC() {
		// TODO Auto-generated method stub
		//TSysIllegalkeywords sample=new TSysIllegalkeywords();
		List ll=illegalwordsDao.findALLByJDBC();
		return ll;
	}
	

	@Override
	public List getList(String beginIndex, String endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllbyHibernate() {
		// TODO Auto-generated method stub
		List ll=illegalwordsDao.findALLByHibernate();

		return ll;
	}

	@Override
	public List getAllbySpringHibernate() {
		// TODO Auto-generated method stub
		List<TSysIllegalkeywords> ll=illegalwordsDao.findBySpringHibernate();
		return ll;
	}

	
	

	@Override
	public List getALLbyGenericDAO() {
		List<TSysIllegalkeywords> ll=illegalwordsDao.queryAll();
		return ll;
	}

}
