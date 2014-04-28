package com.gd158.Utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Tools {
	static Logger logger = Logger.getLogger(Tools.class.getName());

	public static  Object Map2Object(Map map, String classname)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		Iterator it = map.entrySet().iterator();

		Class cls = Class.forName(classname);
		Method meth = null; 
		Object retobj = cls.newInstance();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();

			logger.debug(key + ":" + value);

			try {

				meth = cls.getMethod("set" + (String) key, value.getClass());
				meth.invoke(retobj, value);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				logger.error("配置文件中的属性，没有相应的 java方法");
				// e.printStackTrace();
			}

		}
		return retobj;

	}
	
	public static String Httpreader(String url) {
		try{
		   URL newUrl = new URL(url);
		   URLConnection connect = newUrl.openConnection();
		   connect.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		   DataInputStream dis = new DataInputStream(connect.getInputStream());
		   BufferedReader in = new BufferedReader(new InputStreamReader(dis,"UTF-8"));
		   String html = "";
		   String readLine = null;
		   while((readLine = in.readLine()) != null) {
		    html = html + readLine;
		   }
		   in.close();
		   return html;
		  }catch (MalformedURLException me){
			  logger.error("MalformedURLException" + me);
		  }catch (IOException ioe){
		   logger.error("ioeException" + ioe);
		  }
		  return null;
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String Httpreader(String url, String charset) {
		String r = "";
		String sText = "";
		URLConnection urlcon = null;
		try {
			URL XmlUrl = new URL(url);
			urlcon = XmlUrl.openConnection();
			InputStream in = urlcon.getInputStream();
			String line = "";
			InputStreamReader fileIn = new InputStreamReader(in, charset);
			BufferedReader reader = new BufferedReader(fileIn);
			while ((line = reader.readLine()) != null) {
				sText += line;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 
	 * @param url
	 * @param post
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String Httpreader(String ua, String url, Map<?, ?> post,
			String charset) {
		String r = "";
		String postData = "";
		String sText = "";
		// URLConnection urlcon = null;

		HttpURLConnection urlcon = null;
		try {
			URL XmlUrl = new URL(url);

			// urlcon = XmlUrl.openConnection();
			urlcon = (HttpURLConnection) XmlUrl.openConnection();

			urlcon.setRequestMethod("POST");
			urlcon.addRequestProperty("User-Agent", ua);
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			OutputStream os = urlcon.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			logger.debug("post content=" + Map2Stings(post));
			postData = Map2Stings(post);
			dos.write(postData.getBytes());
			dos.flush();
			dos.close();
			InputStream in = urlcon.getInputStream();
			String line = "";
			InputStreamReader fileIn = new InputStreamReader(in, charset);
			BufferedReader reader = new BufferedReader(fileIn);
			while ((line = reader.readLine()) != null) {
				sText += line + "\n";
			}
			logger.debug("获取" + url + "地址内容成功");
			r = sText;
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return r;
	}

	public static String Httpreader(String ua, String url, Map<?, ?> post,
			String charset, HttpSession session) {
		String r = "";
		String postData = "";
		String sText = "";
		HttpURLConnection urlcon = null;
		try {
			URL XmlUrl = new URL(url);
			urlcon = (HttpURLConnection) XmlUrl.openConnection();

			urlcon.setRequestMethod("POST");
			urlcon.addRequestProperty("User-Agent", ua);

			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);

			OutputStream os = urlcon.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			logger.debug("post content====" + Map2Stings(post));
			postData = Map2Stings(post);
			dos.write(postData.getBytes());
			dos.flush();
			dos.close();
			logger.debug("发送读取" + url + "请求");
			InputStream in = urlcon.getInputStream();
			String line = "";
			InputStreamReader fileIn = new InputStreamReader(in, charset);
			BufferedReader reader = new BufferedReader(fileIn);
			while ((line = reader.readLine()) != null) {
				sText += line + "\n";
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("获取" + url + "地址内容成功");
		r = sText;
		return r;

	}

	@SuppressWarnings("unchecked")
	public static String Map2Stings(Map map) {
		String r = "";
		String con = "";
		for (Object o : map.keySet()) {
			con = con + o.toString() + "=" + map.get(o);
		}
		r = con;
		logger.debug(r);
		return r;

	}

	/**
	 * 获取id 格式YYYYMMDDHHMISSXXX
	 * 
	 * @return
	 */
	public synchronized static String getId() {
		String r = "";
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		r = ts.toString();
		r = r.replace("-", "");
		r = r.replace(" ", "");
		r = r.replace(":", "");
		r = r.replace(".", "");
		while (r.length() < 17) {
			r = r + "0";
		}
		return r;
	}

	/**
	 * 获取系统时间 格式YYYYMMDDHHMISSXXX
	 * 
	 * @return
	 */
	public static String getSysTime() {
		String r = "";
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		r = ts.toString();

		return r;
	}

	/**
	 * 获取当前月下个月的月份 格式YYYYMM
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String getNextYYYYMM() throws ParseException {
		String r = "";

		r = getNextYYYYMM(getCurYYYYMM());
		return r;

	}

	/**
	 * 获取指定月下个月的月份 格式YYYYMM
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static String getNextYYYYMM(String YYYYMM) throws ParseException {
		String r = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

		java.text.Format formatter = new java.text.SimpleDateFormat("yyyyMM");
		Date dd = sdf.parse(YYYYMM);
		long nextMonth = (dd.getTime() / 1000) + 60 * 60 * 24 * 30;
		r = formatter.format(nextMonth * 1000);

		if (r.equals(YYYYMM)) {
			nextMonth = nextMonth + 60 * 60 * 24 * 2;
		}
		r = formatter.format(nextMonth * 1000);
		return r;

	}

	/**
	 * 获取本月的月份 格式YYYYMM
	 * 
	 * @return
	 */
	public static String getCurYYYYMM() {
		String r = "";
		java.text.Format formatter = new java.text.SimpleDateFormat("yyyyMM");
		Date dd = new Date();
		r = formatter.format(dd.getTime());
		return r;

	}

	/**
	 * 获取指定格式的日期
	 * 
	 * @param s
	 * @return
	 */

	public static String getDateString(String s) {
		String r = "";
		java.text.Format formatter = new java.text.SimpleDateFormat(s);
		Date dd = new Date();
		r = formatter.format(dd.getTime());
		return r;

	}
/**
 * example: getDateString(0, "yyyy/MM/dd HH/MI")
 * @param Offset
 * @param Format
 * @return
 */
	public static String getDateString(int Offset, String Format) {
		String r = "";
		java.text.Format formatter = new java.text.SimpleDateFormat(Format);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, Offset);
		Date dd = cal.getTime();

		r = formatter.format(dd.getTime());
		return r;

	}

	public static String pathToBase(String s) {
		s = s.replaceAll("\\\\", "\\\\\\\\\\\\\\\\");

		return s;
	}

	public static void main(String args[]) {
	//	Tools();
		System.out.println("helloworld");
	}

	private static void Tools() {
		// TODO Auto-generated method stub
		System.out.println(getId());

	}

	public static String getLastDayOfthisMonth() {
		Date dd = new Date();
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(dd);
		final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		String r = Integer.toString(lastDay);
		if (r.length() == 1)
			r = "0" + r;
		return r;
	}

	/**
	 * 获取指定日期至今天的月份列表
	 */
	public static Vector getMonthList(String BegingOfYYYYMM) {
		Vector r = new Vector();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		if (BegingOfYYYYMM.equals(null)
				|| BegingOfYYYYMM.equalsIgnoreCase("null"))
			BegingOfYYYYMM = "201011";
		try {
			java.util.Date d1 = sdf.parse(BegingOfYYYYMM);// 开始月份
			java.util.Date d2 = sdf.parse(Tools.getCurYYYYMM());// 当前月份

			if (d1.getTime() - d2.getTime() > 0) {// 开始日期大于当前月，则输出当前月
				r.add(Tools.getCurYYYYMM());
			} else {
				Calendar c1 = Calendar.getInstance();
				Calendar c2 = Calendar.getInstance();

				c1.setTime(d1);
				c2.setTime(d2);
				while (d1.getTime() - d2.getTime() <= 0) {

					if (c1.get(Calendar.MONTH) > 8)
						r.add(Integer.toString(c1.get(Calendar.YEAR))
								+ Integer.toString(c1.get(Calendar.MONTH) + 1));
					else
						r.add(Integer.toString(c1.get(Calendar.YEAR)) + "0"
								+ Integer.toString(c1.get(Calendar.MONTH) + 1));
					c1.add(Calendar.MONTH, 1);
					d1 = c1.getTime();
				}
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;

	}

	public static String getSN() {
		String r = "";
		Date d1 = new Date();
		long ll = d1.getTime();
		r = r + Long.toString(ll);
		return r;

	}

	public static void PrintVector(Vector v) {

		Iterator it = v.iterator();
		while (it.hasNext()) {
			logger.info(it.next().toString());

		}
	}

	public static Vector ClassifiedVector(Vector v, int i) {
		// com.gd158.Tools.Tools.PrintVector(v);

		Vector r = new Vector();
		Iterator it = v.iterator();
		String[][] sright = new String[10][10];// 创建存放内容的数组

		while (it.hasNext()) {
			String stemp = it.next().toString();
			String[] astemp = stemp.split("\\|");
			int j = 0;
			try {
				j = Integer.parseInt(astemp[i]);
			} catch (Exception e) {
				logger.error("tools.ClassifiedVector error");
				e.printStackTrace();
			}
			int jj = -1;
			int k = 0;
			while (k < 9) { // if(s == null || s.length() <= 0);

				if ((sright[j][k] == null || sright[j][k].length() <= 0)
						&& jj < 0)
					jj = k;
				k++;
			}
			sright[j][jj] = stemp;

		}
		r = Transf2Vector(sright);
		return r;
	}

	public static Vector Transf2Vector(String[][] s) {
		Tools.PrintString(s);

		Vector v = new Vector();
		int i = 0;
		int j = 0;
		int k = 0;
		int ii = s.length - 1;
		while (i < ii) {
			int jj = s[i].length - 1;
			Vector v2 = new Vector();
			j = 0;
			k = 0;
			while (j < jj) {
				if (!(s[i][j] == null || s[i][j].length() < 1)) {
					v2.add(s[i][j]);
					k++;
				}

				j++;
			}
			// Tools.PrintVector(v2);
			if (k > 0)
				v.add(v2);
			i++;
		}

		return v;
	}

	public static void PrintString(String[][] s) {
		int i = 0;
		int j = 0;
		int ii = s.length - 1;
		int jj = s[ii].length - 1;
		while (i < ii) {
			j = 0;
			while (j < jj) {
				logger.debug("s[" + i + "][" + j + "]=" + s[i][j]);
				j++;
			}
			i++;
		}

	}

	public static void PrintString(String[] s) {
		int i = 0;
		int ii = s.length - 1;
		while (i < ii) {
			logger.debug("s[" + i + "]=" + s[i]);
			i++;
		}

	}

	/**
	 * * 使用FileChannel拷贝文件 * * @param srcFile * @param destFile * @throws
	 * IOException
	 */
	public static boolean copyUseChannel(File srcFile, File destFile) {
		FileChannel out = null;
		FileChannel in = null;

		try {
			if ((!srcFile.exists()) || (srcFile.isDirectory())) {
				return false;
			}

			if (!destFile.exists()) {
				destFile.createNewFile();
			}

			out = new FileOutputStream(destFile).getChannel();
			in = new FileInputStream(srcFile).getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(102400);
			int position = 0;
			int length = 0;
			while (true) {
				length = in.read(buffer, position);
				if (length <= 0) {
					break;
				} // System.out.println("after read:"+buffer);
				buffer.flip(); // System.out.println("after flip:"+buffer);
				out.write(buffer, position);
				position += length;
				buffer.clear(); // System.out.println("after clear:"+buffer); }
			}

		} catch (IOException e) {
			logger.error("文件copy 发生错误");
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				logger.error("文件关闭发生错误");
			}
		}
		return true;
	}

	public static void LoadClassMethod(String className, String consprep) {
		try {
			Class cls = Class.forName(className);
			Class[] argtype = new Class[] { String.class };// 代表构造方法的参数类型数组
			Object[] argparam = new Object[] { consprep };// 代表构造方法的参数值数组
			Constructor cor = cls.getDeclaredConstructor(argtype); // 构造函数
			Object jb = cor.newInstance(argparam);

			Method m[] = cls.getDeclaredMethods();
			Object pp = null;
			for (int i = 0; i < m.length; i++) {

				logger.debug(m[i].toString() + "=" + m[i].invoke(jb));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 获取域名
	 * 
	 */

	public static String getDomain(HttpServletRequest request) {
		String re = "";
		StringBuffer u1 = request.getRequestURL();

		String url = u1.toString();
		String uri = request.getServletPath();
		re = url.replace(uri, "");
		// logger.debug("Current visit page is" + re);
		return re;

	}

	public static String md5s(String plainText) {
		String re = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			re = buf.toString().toUpperCase();
			logger.debug("result: " + buf.toString());// 32位的加密

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return re;
	}

	/**
	 * md5加密，输出小写加密码
	 * 
	 * @param plainText
	 * @return
	 */
	public static String md5small(String plainText) {
		String re = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			re = buf.toString();
			logger.debug("result: " + buf.toString());// 32位的加密

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return re;
	}

	public static String Map2UrlParameter(Map map) {
		StringBuffer sb = new StringBuffer();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry en = (Map.Entry) it.next();
			Object key = en.getKey();
			Object value = en.getValue();
			sb.append(key + "=" + value + "&");
		}
		sb.deleteCharAt(sb.lastIndexOf("&"));
		return sb.toString();

	}

	public static void PrintSession(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		Map map = request.getParameterMap();
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			String strKey = element.getKey().toString();
			logger.debug("\nkey=" + strKey);
			String[] value = (String[]) element.getValue();
			if (value.length > 0) {
				for (int i = 0; i < value.length; i++)
					logger.debug("\nvalue" + String.valueOf(i) + "="
							+ value[i].toString());
			}
			int a = 1;
		}
	}

	public static void PrintRequest(HttpServletRequest request) {

		Map map = request.getParameterMap();
		StringBuffer sb = new StringBuffer();
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			String strKey = element.getKey().toString();
			String[] value = (String[]) element.getValue();
			if (value.length > 0) {
				for (int i = 0; i < value.length; i++)
					sb.append("\n###### Parameter[" + i + "]:"
							+ strKey + "=" + value[i].toString() + "######");
			}
			int a = 1;
		}
		logger.info(sb);
	}

	public static void printMap(Map map) {
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			logger.debug(key.toString() + "||" + value.toString() + "\n");
		}
	}

	public static String getTimestamp() {
		Date dd = new Date();
		return Long.toString(dd.getTime());
	}

	public static String getStar(String star) {
		String tmp = "";
		if (star.equals("0") || star.equals("1")) {
			tmp = "1";
		} else {
			int c = Integer.parseInt(star) / 2;
			int yu = Integer.parseInt(star) % 2;
			if (yu == 1) {
				tmp = String.valueOf(c) + "5";
			} else if (c > 0) {
				tmp = String.valueOf(c);
			}
		}
		return tmp;
	}

	public static String Vector2Array(Vector v) {
		StringBuffer sb = new StringBuffer();
		Iterator it = v.iterator();
		while (it.hasNext()) {
			sb.append(it.next().toString() + "|");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}

	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	/**
	 * 用于通券的订单号，需要和信天游的订单号统一，20位，前8位为日期，后12位为不重复的随机数字
	 * 
	 * @return
	 */
	public static String getTQSN() {
		String r = "", d = "";
		Date d1 = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		d = sd.format(d1);
		long ll = d1.getTime();
		r = r + d + Long.toString(ll).substring(0, 12);
		return r;
	}

	/**
	 * 增加天数到当前日期。
	 * 
	 * @param now
	 * @param day
	 */
	public static String addDate(String now, int day) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy,MM,dd");
		Calendar fromCal = Calendar.getInstance();
		String result = now;
		try {
			Date date = dateFormat.parse(now);
			fromCal.setTime(date);
			fromCal.add(Calendar.DATE, day);

			System.out.println(dateFormat.format(fromCal.getTime()));
			result = dateFormat.format(fromCal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @param type
	 * @return
	 * @throws ParseException 
	 */
	
	public static  Vector  getDateList(String date1,String beginHour,String date2,String endHour,String type) throws ParseException{
		Vector v=new Vector();
		
		logger.debug(date1+"||"+date2+"||"+type);
		if(type.equalsIgnoreCase("hour")==false){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 将字符串格式化
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日"); // 将字符串格式化
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月"); // 将字符串格式化
		Date sdate=sdf.parse(date1);
		Date edate=sdf.parse(date2);
		Calendar c = Calendar.getInstance();// 初始化一个Calendar
		c.setTime(sdate); // 设置基准日期
		//c.add(Calendar.DATE,1);
		String tt="";
		while (c.getTime().after(edate)==false){
			if(type.equalsIgnoreCase("month")){
				tt=sdf3.format(c.getTime());
				c.add(Calendar.MONTH,1);
			}
			else if(type.equalsIgnoreCase("day")){
				tt=sdf2.format(c.getTime());
				c.add(Calendar.DATE,1);
			}
			v.add(tt);
		}}
		else {
			
			int i=Integer.parseInt(beginHour);
			while (i<=Integer.parseInt(endHour)){
				v.add(i+" 时");
				i++;
			}
			
		}
	
		return v;
	}
	

	/**
	 * 修改日期天数
	 * 
	 * @param baseDate
	 *            基准日期String (格式yyyyMMdd)
	 * @param amount
	 *            要增加的天数（负数为减）
	 * @return 基准日期增加或减少若干天后的日期
	 */
	public static Date dateModify(String baseDate, int amount) {
		StringBuffer sb = new StringBuffer();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 将字符串格式化
		Date dt = sdf.parse(baseDate, new ParsePosition(0)); // 由格式化后的字符串产生一个Date对象

		Calendar c = Calendar.getInstance(); // 初始化一个Calendar
		c.setTime(dt); // 设置基准日期
		c.add(Calendar.DATE, amount); // 你要加减的日期
		Date dt1 = c.getTime(); // 从Calendar对象获得基准日期增减后的日期

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日"); // 将字符串格式化
		sb = sdf2.format(dt1, sb, new FieldPosition(0)); // 得到结果字符串

		return dt1;
	}

	public static String setstar(String s, int start, int length) {
		String result = "", tmp1 = "", tmp2 = "", tmp3 = "", tmp = "";
		tmp1 = s.substring(0, start - 1);// 截取第一段
		tmp2 = s.substring(start, length);
		tmp3 = s.substring(start + length - 1, s.length());
		for (int i = 0; i < length; i++) {
			tmp = tmp + "*";
		}

		result = tmp1 + tmp + tmp3;
		logger.debug("屏蔽后=" + result);
		return result;
	}

	public static void testDigest() {
		try {
			String myinfo = "我的测试信息";
			java.security.MessageDigest alg = java.security.MessageDigest
					.getInstance("MD5");
			// java.security.MessageDigest
			// alga=java.security.MessageDigest.getInstance("SHA-1");
			alg.update(myinfo.getBytes());
			byte[] digesta = alg.digest();
			System.out.println("本信息摘要是 :" + byte2hex(digesta));

		} catch (java.security.NoSuchAlgorithmException ex) {
			System.out.println("非法摘要算法");
		}
	}

	public static String byte2hex(byte[] b) // 二行制转字符串
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	public static String replaceString(String src, String before, String after) {
		StringBuffer sb = new StringBuffer();
		int oldidx = 0;
		int idx = src.indexOf(before);
		while (idx != -1) {
			sb.append(src.substring(oldidx, idx)).append(after);
			oldidx = idx + before.length();
			idx = src.indexOf(before, oldidx);
		}
		if (oldidx < src.length())
			sb.append(src.substring(oldidx));
		return sb.toString();
	}

	public static String saveToXMLFile(String filename,String content){
		String re="保存xml文件成功,后台已经刷新权限";
		Document doc;
		try {
			doc=DocumentHelper.parseText(content);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			re="xml文件格式错误";
			return re;
		}
	
		try {

  
			org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(
		            new FileOutputStream(filename));
		        xmlWriter.write(doc);
		        xmlWriter.close();

			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			re="写入xml文件发生错误";
			return re;
		}
		
		return re;
	}
	
	
	public static String readXMLFile(String filename){
		String re="";
		Document doc;
		SAXReader saxReader = new SAXReader();
		try {
			doc= saxReader.read(filename);
			re=doc.asXML();
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			re="xml文件读取错误";
			return re;
		}
		return re;
	}
	


}
