package com.weini.manage.entity;
// default package

/**
 * TBoxtype entity. @author MyEclipse Persistence Tools
 */

public class TBoxtype implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String desc1;
	private String desc2;
	private String desc3;
	private String desc4;
	private String typename;
	private Integer time;

	// Constructors

	/** default constructor */
	public TBoxtype() {
	}

	/** full constructor */
	public TBoxtype(String desc1, String desc2, String desc3, String desc4,
			String typename, Integer time) {
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.desc4 = desc4;
		this.typename = typename;
		this.time = time;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getDesc1() {
		return this.desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return this.desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getDesc3() {
		return this.desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	public String getDesc4() {
		return this.desc4;
	}

	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}