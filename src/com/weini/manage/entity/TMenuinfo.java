package com.weini.manage.entity;

// default package

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * TMenuinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_menuinfo")
public class TMenuinfo implements java.io.Serializable {

	// Fields

	private Integer menuinfoId;
	private String menuinfoName;
	private Integer vendorId;
	private String menuinfoImage1;
	private String menuinfoImage2;
	private String menuinfoImage3;
	private String menuinfoImage4;
	private String menuinfoDetail;
	private Timestamp menuinfoDate;
	private Integer menuinfoStatus;
	private Float menuinfoPoint;
	private Integer menuinfoWestern;
	private Integer menuinfoType;
	private Integer menuinfoConsumernum;
	private Integer menuinfoBusinessAreaID;

	// add
	private String vendorName;
	private String bussinessName;
	private int order;
	private String menuinfoDateString;
	// wangadd
	private List<TDishes> dishesList;
	private String menuType;
	
	/** default constructor */
	public TMenuinfo() {
	}

	// Constructors

	/** minimal constructor */
	public TMenuinfo(String menuinfoName, Integer vendorId,
			Timestamp menuinfoDate, Integer menuinfoStatus) {
		this.menuinfoName = menuinfoName;
		this.vendorId = vendorId;
		this.menuinfoDate = menuinfoDate;
		this.menuinfoStatus = menuinfoStatus;
	}

	/** full constructor */
	public TMenuinfo(String menuinfoName, Integer vendorId,
			String menuinfoImage1, String menuinfoImage2,
			String menuinfoImage3, String menuinfoImage4,
			String menuinfoDetail, Timestamp menuinfoDate,
			Integer menuinfoStatus, Float menuinfoPoint,
			Integer menuinfoWestern, Integer menuinfoType,
			Integer menuinfoConsumernum) {
		this.menuinfoName = menuinfoName;
		this.vendorId = vendorId;
		this.menuinfoImage1 = menuinfoImage1;
		this.menuinfoImage2 = menuinfoImage2;
		this.menuinfoImage3 = menuinfoImage3;
		this.menuinfoImage4 = menuinfoImage4;
		this.menuinfoDetail = menuinfoDetail;
		this.menuinfoDate = menuinfoDate;
		this.menuinfoStatus = menuinfoStatus;
		this.menuinfoPoint = menuinfoPoint;
		this.menuinfoWestern = menuinfoWestern;
		this.menuinfoType = menuinfoType;
		this.menuinfoConsumernum = menuinfoConsumernum;
	}

	// Property accessors
	@Id
	// 表示主键
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	// 自增长
	@Column(name = "menuinfo_id")
	public Integer getMenuinfoId() {
		return this.menuinfoId;
	}

	public void setMenuinfoId(Integer menuinfoId) {
		this.menuinfoId = menuinfoId;
	}

	@Column(name = "menuinfo_name", nullable = false)
	public String getMenuinfoName() {
		return this.menuinfoName;
	}

	public void setMenuinfoName(String menuinfoName) {
		this.menuinfoName = menuinfoName;
	}

	@Column(name = "vendor_id", nullable = false)
	public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	@Column(name = "menuinfo_image1")
	public String getMenuinfoImage1() {
		return this.menuinfoImage1;
	}

	public void setMenuinfoImage1(String menuinfoImage1) {
		this.menuinfoImage1 = menuinfoImage1;
	}

	@Column(name = "menuinfo_image2")
	public String getMenuinfoImage2() {
		return this.menuinfoImage2;
	}

	public void setMenuinfoImage2(String menuinfoImage2) {
		this.menuinfoImage2 = menuinfoImage2;
	}

	@Column(name = "menuinfo_image3")
	public String getMenuinfoImage3() {
		return this.menuinfoImage3;
	}

	public void setMenuinfoImage3(String menuinfoImage3) {
		this.menuinfoImage3 = menuinfoImage3;
	}

	@Column(name = "menuinfo_image4")
	public String getMenuinfoImage4() {
		return this.menuinfoImage4;
	}

	public void setMenuinfoImage4(String menuinfoImage4) {
		this.menuinfoImage4 = menuinfoImage4;
	}

	@Column(name = "menuinfo_detail")
	public String getMenuinfoDetail() {
		return this.menuinfoDetail;
	}

	public void setMenuinfoDetail(String menuinfoDetail) {
		this.menuinfoDetail = menuinfoDetail;
	}

	@Column(name = "menuinfo_date", nullable = false)
	public Timestamp getMenuinfoDate() {
		return this.menuinfoDate;
	}

	public void setMenuinfoDate(Timestamp menuinfoDate) {
		this.menuinfoDate = menuinfoDate;
	}

	@Column(name = "menuinfo_status", nullable = false)
	public Integer getMenuinfoStatus() {
		return this.menuinfoStatus;
	}

	public void setMenuinfoStatus(Integer menuinfoStatus) {
		this.menuinfoStatus = menuinfoStatus;
	}

	@Column(name = "menuinfo_point")
	public Float getMenuinfoPoint() {
		return this.menuinfoPoint;
	}

	public void setMenuinfoPoint(Float menuinfoPoint) {
		this.menuinfoPoint = menuinfoPoint;
	}

	@Column(name = "menuinfo_type")
	public Integer getMenuinfoType() {
		return this.menuinfoType;
	}

	public void setMenuinfoType(Integer menuinfoType) {
		this.menuinfoType = menuinfoType;
	}

	@Column(name = "menuinfo_consumernum")
	public Integer getMenuinfoConsumernum() {
		return this.menuinfoConsumernum;
	}

	public void setMenuinfoConsumernum(Integer menuinfoConsumernum) {
		this.menuinfoConsumernum = menuinfoConsumernum;
	}

	@Transient
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Transient
	public String getBussinessName() {
		return bussinessName;
	}

	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}

	@Transient
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		// 两种方式都可以
		// return ReflectionToStringBuilder.toString(this);
		return ToStringBuilder.reflectionToString(this);
	}
	@Column(name = "menuinfo_western")
	public Integer getMenuinfoWestern() {
		return menuinfoWestern;
	}

	public void setMenuinfoWestern(Integer menuinfoWestern) {
		this.menuinfoWestern = menuinfoWestern;
	}
	@Column(name = "menuinfo_bussinessAreaID", nullable = false)
	public Integer getMenuinfoBusinessAreaID() {
		return menuinfoBusinessAreaID;
	}

	public void setMenuinfoBusinessAreaID(Integer menuinfoBusinessAreaID) {
		this.menuinfoBusinessAreaID = menuinfoBusinessAreaID;
	}
	@Transient
	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	
	@Transient
	public String getStringMenuinfoDate() {
		if(this.menuinfoDate != null){
			return this.menuinfoDate.toString();
		}else{
			return "";
		}
	}
	@Transient
	public List<TDishes> getDishesList() {
		if(this.dishesList == null){
			return (new ArrayList<TDishes>());
		}else{
			return this.dishesList;
		}
	}

	public void setDishesList(List<TDishes> dishesList) {
		this.dishesList = dishesList;
	}
	@Transient
	public String getMenuinfoDateString() {
		if(this.menuinfoDate != null){
			return menuinfoDate.toString();
		}else{
			return "";
		}
	}
}
