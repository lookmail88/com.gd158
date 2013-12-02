package com.gd158.Services;

import java.util.List;



public interface Illegalkeywords {
	public String add(String keywords);
	public String del(String keywords);
	public String get(String keywords);
	public List getAllbyJDBC();
	public List getAllbyHibernate();
	public List getAllbySpringHibernate();
	public List getALLbyGenericDAO();
	public List getList(String beginIndex,String endIndex);
}
