package com.gd158.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;



/**
 * @author Cecil E-mail:lookmail88@gmail.com
 * @version Created time： 2012-8-1 上午9:57:10
 * 类描述:TODO
 */

public class DBConn {
	static Logger logger = Logger.getLogger(DBConn.class.getName());

	String Sqls = "";
	InitialContext initCtx;
	DataSource ds = null;
	Connection conn = null;
	Statement stmt = null;
	String Connurl = "";
	PreparedStatement ps = null;

	private Boolean prgetUpdate;

	public DBConn(String connurl) {
		try {
			this.Connurl = connurl;
			initCtx = new InitialContext();

			ds = (DataSource) initCtx.lookup(this.Connurl);
			conn = ds.getConnection();
			stmt = conn.createStatement();

		} catch (SQLException e) {
			logger.error("error in dbconnect:SQLException");
			e.printStackTrace();
		} catch (NamingException e) {
			logger.debug("error in dbconnect:NamingException");
			e.printStackTrace();

		}
	}

	/**
	 * ��ݿ��ѯ�����ص���vector�࣬��|�ָ�
	 * 
	 * @param sqls
	 * @return
	 * @throws SQLException
	 */

	public synchronized Vector<String> getResult(String sqls)
			throws SQLException {
		Vector<String> v = new Vector<String>();

		try {
			PreparedStatement ps = conn.prepareStatement(sqls);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String s = "";
				int i = 1;
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				while (i <= columnCount) {
					s = s + "|" + rs.getString(i);
					i++;
				}
				v.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return v;
	}

	/**
	 * 
	 * @param sqls
	 * @return
	 * @throws Exception
	 */

	public synchronized Boolean getUpdate(String sqls) throws Exception {
		int r = 0;

		try {
			PreparedStatement ps = conn.prepareStatement(sqls);
			r = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		if (r > 0)
			return true;
		else
			return false;

	}

	/**
	 * ��ݿ������������ͨ������ ����sqls ��ʽ��sql��� һ��������ֻ����1��select������update��delete��insert
	 * 
	 * @param sqls
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */

	public synchronized Vector getResult(Vector vsqls) {
		Vector<String> v = new Vector<String>();
		String co = "";
		Iterator it = vsqls.iterator();
		try {

			//conn.setAutoCommit(false);

			while (it.hasNext()) {
				co = it.next().toString();
				if (co.substring(1, 6).equalsIgnoreCase("select") == true)
					v = this.prgetResult(co);
				else
					this.prgetUpdate(co);

			}
			//conn.commit();
		} catch (SQLException e) {
			try {
				logger.error(co);
				conn.rollback();
				logger.error("ϵͳ�ع�");
			} catch (SQLException e1) {
				logger.error("ϵͳ�ع����ִ���");
				e1.printStackTrace();
			}

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			try {

				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return v;

	}

	private synchronized Vector<String> prgetResult(String sqls)
			throws SQLException {
		Vector<String> v = new Vector<String>();

		PreparedStatement ps = conn.prepareStatement(sqls);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String s = "";
			int i = 1;
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (i <= columnCount) {
				s = s + "|" + rs.getString(i);
				i++;
			}
			v.add(s);
		}
		return v;
	}

	/**
	 * 
	 * @param sqls
	 * @return
	 * @throws Exception
	 */

	private synchronized Boolean prgetUpdate(String sqls) throws Exception {
		int r = 0;

		PreparedStatement ps = conn.prepareStatement(sqls);
		r = ps.executeUpdate();

		if (r > 0)
			return true;
		else
			return false;

	}

	private synchronized Boolean closeconn() throws Exception {
		Boolean b = true;
		conn.close();
		return b;
	}

}
