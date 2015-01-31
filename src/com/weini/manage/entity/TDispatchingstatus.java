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
 * TDispatchingstatus entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_dispatchingstatus")
public class TDispatchingstatus implements java.io.Serializable {

	// Fields

	private Integer dispatchingStatusId;
	private String dispatchingStatusImagename;
	private String dispatchingStatusDesctext;

	// Constructors

	/** default constructor */
	public TDispatchingstatus() {
	}

	/** full constructor */
	public TDispatchingstatus(String dispatchingStatusImagename,
			String dispatchingStatusDesctext) {
		this.dispatchingStatusImagename = dispatchingStatusImagename;
		this.dispatchingStatusDesctext = dispatchingStatusDesctext;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "dispatchingStatus_id") 
	public Integer getDispatchingStatusId() {
		return this.dispatchingStatusId;
	}

	public void setDispatchingStatusId(Integer dispatchingStatusId) {
		this.dispatchingStatusId = dispatchingStatusId;
	}
	@Column(name = "dispatchingStatus_imagename",nullable = false)
	public String getDispatchingStatusImagename() {
		return this.dispatchingStatusImagename;
	}

	public void setDispatchingStatusImagename(String dispatchingStatusImagename) {
		this.dispatchingStatusImagename = dispatchingStatusImagename;
	}
	@Column(name = "dispatchingStatus_desctext",nullable = false)
	public String getDispatchingStatusDesctext() {
		return this.dispatchingStatusDesctext;
	}

	public void setDispatchingStatusDesctext(String dispatchingStatusDesctext) {
		this.dispatchingStatusDesctext = dispatchingStatusDesctext;
	}
	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }

}