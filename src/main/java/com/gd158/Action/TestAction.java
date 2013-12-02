package com.gd158.Action;



import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd158.Entity.DataBaseMapping.TSysIllegalkeywords;
import com.gd158.Services.Illegalkeywords;

@Controller
@RequestMapping("/test")
public class TestAction {
	
	static Logger logger = Logger.getLogger(TestAction.class.getName());
	
	private Illegalkeywords illegalkeywordsServices;
	
	
	public Illegalkeywords getIllegalkeywordsServices() {
		return illegalkeywordsServices;
	}

	public void setIllegalkeywordsServices(Illegalkeywords illegalkeywordsServices) {
		this.illegalkeywordsServices = illegalkeywordsServices;
	}

	@RequestMapping(value="/index")//
	public String getMoblielist(Model model,HttpServletRequest request)throws Exception{
		String re="Test/Example";//返回的jsp页面		
		logger.info("\n######Enter Test Controller######");		
		return re;
	}
	//Ajax-String
	@RequestMapping(value="/Ajax-String")
	@ResponseBody
	public String getAjaxTest(){
		String re="";
		Date dd=new Date();
		re=Long.toString(dd.getTime());
		return re;
	}
	
	@RequestMapping(value="/DBRead-jdbctest")
	@ResponseBody
	public String getDBtest(){
		String re="";
		List ll= illegalkeywordsServices.getAllbyJDBC();
		java.util.Iterator it=ll.iterator();
		
		while(it.hasNext()){
			re=re+it.next().toString()+"<br/>";
		}
		try {
			re=new String(re.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	@RequestMapping(value="/DBReadHibernate")
	@ResponseBody
	public String getDBReadHibernate(){
		String re="";
		List<TSysIllegalkeywords> ll= illegalkeywordsServices.getAllbyHibernate();
		java.util.Iterator<TSysIllegalkeywords> it=ll.iterator();
		
		while(it.hasNext()){
			TSysIllegalkeywords ts=it.next();
			re=re+"<br/>"+ts.getKeywords();
		}
		try {
			re=new String(re.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	@RequestMapping(value="/DBReadSpringHibernate")
	@ResponseBody
	public String DBReadSpringHibernate(){
		String re="";
		List<TSysIllegalkeywords> ll= illegalkeywordsServices.getAllbySpringHibernate();
		java.util.Iterator<TSysIllegalkeywords> it=ll.iterator();
		
		while(it.hasNext()){
			TSysIllegalkeywords ts=it.next();
			re=re+"<br/>"+ts.getKeywords();
		}
		try {
			re=new String(re.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	@RequestMapping(value="/DBReadGenericDAO")
	@ResponseBody
	public String getDBReadGenericDAO(){
		String re="";
		List<TSysIllegalkeywords> ll= illegalkeywordsServices.getAllbySpringHibernate();
		java.util.Iterator<TSysIllegalkeywords> it=ll.iterator();
		
		while(it.hasNext()){
			TSysIllegalkeywords ts=it.next();
			re=re+"<br/>"+ts.getKeywords();
		}
		try {
			re=new String(re.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
}
