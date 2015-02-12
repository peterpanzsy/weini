package com.weini.manage.entity;
// default package

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * TUserextra entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_userextra")
public class TUserextra implements java.io.Serializable {

	// Fields

	private Integer userextraId;
	private Integer userId;
	private String userextraImage = "";
	private String userextraReserved = "";
	private Date userextraBirthday;

	private String userextraBirthdayString;

	// Constructors

	/** default constructor */
	public TUserextra() {
	}

	/** minimal constructor */
	public TUserextra(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TUserextra(Integer userId, String userextraImage,
			String userextraReserved, Date userextraBirthday) {
		this.userId = userId;
		this.userextraImage = userextraImage;
		this.userextraReserved = userextraReserved;
		this.userextraBirthday = userextraBirthday;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "userextra_id") 
	public Integer getUserextraId() {
		return this.userextraId;
	}

	public void setUserextraId(Integer userextraId) {
		this.userextraId = userextraId;
	}
	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name = "userextra_image")
	public String getUserextraImage() {
		return this.userextraImage;
	}

	public void setUserextraImage(String userextraImage) {
		this.userextraImage = userextraImage;
	}
	@Column(name = "userextra_reserved")
	public String getUserextraReserved() {
		return this.userextraReserved;
	}

	public void setUserextraReserved(String userextraReserved) {
		this.userextraReserved = userextraReserved;
	}
	@Column(name = "userextra_birthday")
	public Date getUserextraBirthday() {
		return this.userextraBirthday;
	}

	public void setUserextraBirthday(Date userextraBirthday) {
		this.userextraBirthday = userextraBirthday;
	}
	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }
	@Transient
	public String getUserextraBirthdayString() {
		if(this.userextraBirthday != null){
			return new SimpleDateFormat("yyyy-MM-dd").format(userextraBirthday);
		}else{
			return "";
		}
		
	}
}