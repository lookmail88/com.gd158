// default package
// Generated 2013-9-5 13:01:41 by Hibernate Tools 4.0.0
package com.gd158.Entity.DataBaseMapping;

import java.util.Date;

import javax.persistence.Table;

import org.hibernate.annotations.Entity;

/**
 * TSysIllegalkeywords generated by hbm2java
 */

public class TSysIllegalkeywords implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keywords;
	private Integer id;
	private Date setdate;
	private String setuserid;
	private String memory1;
	private String memory2;
	private String memory3;

	public TSysIllegalkeywords() {
	}

	public TSysIllegalkeywords(String keywords) {
		this.keywords = keywords;
	}

	public TSysIllegalkeywords(String keywords, Integer id, Date setdate,
			String setuserid, String memory1, String memory2, String memory3) {
		this.keywords = keywords;
		this.id = id;
		this.setdate = setdate;
		this.setuserid = setuserid;
		this.memory1 = memory1;
		this.memory2 = memory2;
		this.memory3 = memory3;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSetdate() {
		return this.setdate;
	}

	public void setSetdate(Date setdate) {
		this.setdate = setdate;
	}

	public String getSetuserid() {
		return this.setuserid;
	}

	public void setSetuserid(String setuserid) {
		this.setuserid = setuserid;
	}

	public String getMemory1() {
		return this.memory1;
	}

	public void setMemory1(String memory1) {
		this.memory1 = memory1;
	}

	public String getMemory2() {
		return this.memory2;
	}

	public void setMemory2(String memory2) {
		this.memory2 = memory2;
	}

	public String getMemory3() {
		return this.memory3;
	}

	public void setMemory3(String memory3) {
		this.memory3 = memory3;
	}

}
