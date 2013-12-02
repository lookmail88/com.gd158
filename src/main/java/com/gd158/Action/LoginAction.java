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
@RequestMapping("/login")
public class LoginAction {
	
	static Logger logger = Logger.getLogger(LoginAction.class.getName());
	
	private Illegalkeywords illegalkeywordsServices;
	
	
	public Illegalkeywords getIllegalkeywordsServices() {
		return illegalkeywordsServices;
	}

	public void setIllegalkeywordsServices(Illegalkeywords illegalkeywordsServices) {
		this.illegalkeywordsServices = illegalkeywordsServices;
	}

	@RequestMapping(value="/login")//
	public String getMoblielist(Model model,HttpServletRequest request)throws Exception{
		String re="Reader/index";//返回的jsp页面		
		logger.info("\n######Enter Login Controller######");		
		return re;
	}
	
}
