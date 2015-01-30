package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// default package


import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * TCookinfo entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_cookinfo")
public class TCookinfo implements java.io.Serializable {

	// Fields

	private Integer cookinfoId;
	private String cookinfoName;
	private String cookinfoImage;
	private Integer cookinfoVendorid;

	// Constructors

	/** default constructor */
	public TCookinfo() {
	}

	/** minimal constructor */
	public TCookinfo(String cookinfoName, Integer cookinfoVendorid) {
		this.cookinfoName = cookinfoName;
		this.cookinfoVendorid = cookinfoVendorid;
	}

	/** full constructor */
	public TCookinfo(String cookinfoName, String cookinfoImage,
			Integer cookinfoVendorid) {
		this.cookinfoName = cookinfoName;
		this.cookinfoImage = cookinfoImage;
		this.cookinfoVendorid = cookinfoVendorid;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "cookinfo_id") 
	public Integer getCookinfoId() {
		return this.cookinfoId;
	}

	public void setCookinfoId(Integer cookinfoId) {
		this.cookinfoId = cookinfoId;
	}
	@Column(name = "cookinfo_name",nullable = false)
	public String getCookinfoName() {
		return this.cookinfoName;
	}

	public void setCookinfoName(String cookinfoName) {
		this.cookinfoName = cookinfoName;
	}
	@Column(name = "cookinfo_image")
	public String getCookinfoImage() {
		return this.cookinfoImage;
	}

	public void setCookinfoImage(String cookinfoImage) {
		this.cookinfoImage = cookinfoImage;
	}
	@Column(name = "cookinfo_vendorid",nullable = false)
	public Integer getCookinfoVendorid() {
		return this.cookinfoVendorid;
	}

	public void setCookinfoVendorid(Integer cookinfoVendorid) {
		this.cookinfoVendorid = cookinfoVendorid;
	}
	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }

}