package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package

import org.hibernate.annotations.GenericGenerator;

/**
 * TMenutype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_menutype")
public class TMenutype implements java.io.Serializable {

	// Fields

	private Integer menutypeId;
	private String menutypeDesc;

	// Constructors

	/** default constructor */
	public TMenutype() {
	}

	/** full constructor */
	public TMenutype(String menutypeDesc) {
		this.menutypeDesc = menutypeDesc;
	}

	// Property accessors
	@Id
	// 表示主键
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	// 自增长
	@Column(name = "menutype_id")
	public Integer getMenutypeId() {
		return this.menutypeId;
	}

	public void setMenutypeId(Integer menutypeId) {
		this.menutypeId = menutypeId;
	}
	@Column(name = "menutype_desc", nullable = false)
	public String getMenutypeDesc() {
		return this.menutypeDesc;
	}

	public void setMenutypeDesc(String menutypeDesc) {
		this.menutypeDesc = menutypeDesc;
	}

}