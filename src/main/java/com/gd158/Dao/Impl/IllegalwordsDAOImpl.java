package com.gd158.Dao.Impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.gd158.Dao.IllegalwordsDAO;
import com.gd158.Entity.DataBaseMapping.TSysIllegalkeywords;

import com.gd158.Dao.DBConn;


@Repository("illegalwordsDao")
public class IllegalwordsDAOImpl extends GenericDAO<TSysIllegalkeywords> implements IllegalwordsDAO{

	public IllegalwordsDAOImpl() {
		super(TSysIllegalkeywords.class);
	}

	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List findALLByJDBC(){
		String sqls="select keywords  from T_Sys_Illegalkeywords";
		DBConn dbc = new DBConn(com.gd158.Utils.Setting.MVC158DBURL);
		List ll=null;
		try {
			 ll=dbc.getResult(sqls);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	};
	
	@SuppressWarnings("unchecked")
	public List<TSysIllegalkeywords> findALLByHibernate(){
		List<TSysIllegalkeywords> ll=null;
		
		 Configuration cfg = new Configuration();  
	        cfg.configure();  
	        ServiceRegistry  sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();   
	        SessionFactory  sf = cfg.buildSessionFactory(sr);  
	        Session s = sf.openSession();  
	       ll=s.createQuery(" from TSysIllegalkeywords").list();
	      
	        s.close();  
	        sf.close();  
	        
		return ll;
	}

	@Override
	public List<TSysIllegalkeywords> findBySpringHibernate() {
		 String query=" from TSysIllegalkeywords";
		 Session ss=sessionFactory.getCurrentSession();
		 @SuppressWarnings("unchecked")
		 List<TSysIllegalkeywords> ll=(List<TSysIllegalkeywords>)ss.createQuery(query).list();
		
		return ll;
	}

	

}
