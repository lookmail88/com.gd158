package com.gd158.Action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gd158.Utils.Tools;





@Controller
@RequestMapping("/jqgrid")
public class JqGrid<T> {
	static Logger logger = Logger.getLogger(JqGrid.class.getName());
	private Class<T> entityClass; 
	
	@RequestMapping(value = "/{classname}", method = RequestMethod.GET)
	public String genericJqGrid(Model model,
			@PathVariable("classname") String classname, HttpServletRequest request){
		logger.debug("######genericJqGrid Begin######");
		Tools.PrintRequest(request);

		int opsign = 0;

		if (request.getParameter("oper") != null
				&& request.getParameter("oper").equalsIgnoreCase("add"))
			opsign = 1;// add a new record

		if (request.getParameter("oper") != null
				&& request.getParameter("oper").equalsIgnoreCase("del"))
			opsign = 2;// delete a record

		if (request.getParameter("oper") != null
				&& request.getParameter("oper").equalsIgnoreCase("edit"))
			opsign = 3;// update a record

		switch (opsign) {
		case 1:// add a new record

			break;
		case 2:// delete a record
			int id = Integer.parseInt(request.getParameter("id"));
			

			break;
		case 3:
			opsign = 3;// update a record

			break;
		}
		return getJson();
	}
	
	private  void getObjectAction(T t,String classname,String option){
		try {
			Class c=Class.forName(classname+"DAO");
			c.getMethod(option, (Class[]) t);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private String getJson(){
	/**	
		Iterator it = listtroubleinfo.iterator();
		StringBuffer sb = new StringBuffer();
		int i = 1;//
		sb.append("{");
		sb.append("\"total\":\"" + listtroubleinfo.size() + "\",");
		sb.append("\"page\":\"1\",");
		sb.append("\"records\":\"" + listtroubleinfo.size() + "\",");
		sb.append("\"rows\":[");
		while (it.hasNext()) {
			
			sb.append("{");
			sb.append("\"id\":\"" + v.getTPicId() + "\",");
			sb.append("\"mobile\":\""
					+ new String(v.getTMobile().getBytes("utf-8"), "ISO-8859-1")
					+ "\",");
			sb.append("\"status\":\""
					+ new String(v.getTState().getBytes("utf-8"), "ISO-8859-1")
					+ "\",");
			sb.append("\"title\":\""
					+ new String(v.getTPicTitle().getBytes("utf-8"),
							"ISO-8859-1") + "\",");
			sb.append("\"reportdate\":\""
					+ new String(v.getTPicTime().toString().getBytes("utf-8"),
							"ISO-8859-1") + "\",");
			sb.append("\"picid\":\""
					+ new String(v.getTCaixinId().toString().getBytes("utf-8"),
							"ISO-8859-1") + "\",");
			sb.append("\"picpath\":\""
					+ new String(v.getTPicPath().toString().getBytes("utf-8"),
							"ISO-8859-1") + "\"");
			sb.append("}");
			if (it.hasNext())
				sb.append(",");
			i++;
		}
		sb.append("]}");

		logger.debug(sb.toString());
		logger.debug("######getTroubleList End######");
		return sb.toString();//*/
		return null;
	}
}
