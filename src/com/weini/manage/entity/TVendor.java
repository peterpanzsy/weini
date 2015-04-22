package com.weini.manage.entity;
// default package

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * TVendor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_vendor")
public class TVendor implements java.io.Serializable {

	// Fields

	private Integer vendorId;
	private String vendorName = "";
	private String vendorMail = "";
	private String vendorPhonenum = "";
	private String vendorPwd = "";
	private Integer vendorIsopen = -1;
	private Double vendorTotalmoney = 0.0;
	private Double vendorPaidmoney = 0.0;
	private Double vendorRemainedmoney = 0.0;
	private Integer vendorEmployernum = -1;
	private Integer vendorCooknum = -1;
	private String vendorDetail = "";
	private Timestamp vendorShophourStart;
	private Integer vendorPaytype = -1;
	private Integer vendorBusinessAreaid = -1;
	private Integer vendorDefaultAccountid = -1;
	private Timestamp vendorShophourEnd;
	
	private String vendorShophourStartString;
	private String vendorShophourEndString;
	

	// Constructors

	/** default constructor */
	public TVendor() {
	}

	/** minimal constructor */
	public TVendor(String vendorName, String vendorPhonenum, String vendorPwd,
			Integer vendorIsopen, Timestamp vendorShophourStart,
			Integer vendorPaytype, Integer vendorBusinessAreaid,
			Integer vendorDefaultAccountid, Timestamp vendorShophourEnd) {
		this.vendorName = vendorName;
		this.vendorPhonenum = vendorPhonenum;
		this.vendorPwd = vendorPwd;
		this.vendorIsopen = vendorIsopen;
		this.vendorShophourStart = vendorShophourStart;
		this.vendorPaytype = vendorPaytype;
		this.vendorBusinessAreaid = vendorBusinessAreaid;
		this.vendorDefaultAccountid = vendorDefaultAccountid;
		this.vendorShophourEnd = vendorShophourEnd;
	}

	/** full constructor */
	public TVendor(String vendorName, String vendorMail, String vendorPhonenum,
			String vendorPwd, Integer vendorIsopen, Double vendorTotalmoney,
			Double vendorPaidmoney, Double vendorRemainedmoney,
			Integer vendorEmployernum, Integer vendorCooknum,
			String vendorDetail, Timestamp vendorShophourStart,
			Integer vendorPaytype, Integer vendorBusinessAreaid,
			Integer vendorDefaultAccountid, Timestamp vendorShophourEnd) {
		this.vendorName = vendorName;
		this.vendorMail = vendorMail;
		this.vendorPhonenum = vendorPhonenum;
		this.vendorPwd = vendorPwd;
		this.vendorIsopen = vendorIsopen;
		this.vendorTotalmoney = vendorTotalmoney;
		this.vendorPaidmoney = vendorPaidmoney;
		this.vendorRemainedmoney = vendorRemainedmoney;
		this.vendorEmployernum = vendorEmployernum;
		this.vendorCooknum = vendorCooknum;
		this.vendorDetail = vendorDetail;
		this.vendorShophourStart = vendorShophourStart;
		this.vendorPaytype = vendorPaytype;
		this.vendorBusinessAreaid = vendorBusinessAreaid;
		this.vendorDefaultAccountid = vendorDefaultAccountid;
		this.vendorShophourEnd = vendorShophourEnd;
	}

	// Property accessors
    @Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "vendor_id")
    public Integer getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
    @Column(name = "vendor_name")
	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
    @Column(name = "vendor_mail")
	public String getVendorMail() {
		return this.vendorMail;
	}

	public void setVendorMail(String vendorMail) {
		this.vendorMail = vendorMail;
	}
    @Column(name = "vendor_phonenum")
	public String getVendorPhonenum() {
		return this.vendorPhonenum;
	}

	public void setVendorPhonenum(String vendorPhonenum) {
		this.vendorPhonenum = vendorPhonenum;
	}
    @Column(name = "vendor_pwd")
	public String getVendorPwd() {
		return this.vendorPwd;
	}

	public void setVendorPwd(String vendorPwd) {
		this.vendorPwd = vendorPwd;
	}
    @Column(name = "vendor_isopen")
	public Integer getVendorIsopen() {
		return this.vendorIsopen;
	}

	public void setVendorIsopen(Integer vendorIsopen) {
		this.vendorIsopen = vendorIsopen;
	}
    @Column(name = "vendor_totalmoney")
	public Double getVendorTotalmoney() {
		return this.vendorTotalmoney;
	}

	public void setVendorTotalmoney(Double vendorTotalmoney) {
		this.vendorTotalmoney = vendorTotalmoney;
	}
    @Column(name = "vendor_paidmoney")
	public Double getVendorPaidmoney() {
		return this.vendorPaidmoney;
	}

	public void setVendorPaidmoney(Double vendorPaidmoney) {
		this.vendorPaidmoney = vendorPaidmoney;
	}
    @Column(name = "vendor_remainedmoney")
	public Double getVendorRemainedmoney() {
		return this.vendorRemainedmoney;
	}

	public void setVendorRemainedmoney(Double vendorRemainedmoney) {
		this.vendorRemainedmoney = vendorRemainedmoney;
	}
    @Column(name = "vendor_employernum")
	public Integer getVendorEmployernum() {
		return this.vendorEmployernum;
	}

	public void setVendorEmployernum(Integer vendorEmployernum) {
		this.vendorEmployernum = vendorEmployernum;
	}
    @Column(name = "vendor_cooknum")
	public Integer getVendorCooknum() {
		return this.vendorCooknum;
	}

	public void setVendorCooknum(Integer vendorCooknum) {
		this.vendorCooknum = vendorCooknum;
	}
    @Column(name = "vendor_detail")
	public String getVendorDetail() {
		return this.vendorDetail;
	}

	public void setVendorDetail(String vendorDetail) {
		this.vendorDetail = vendorDetail;
	}
    @Column(name = "vendor_shophour_start")
	public Timestamp getVendorShophourStart() {
		return this.vendorShophourStart;
	}

	public void setVendorShophourStart(Timestamp vendorShophourStart) {
		this.vendorShophourStart = vendorShophourStart;
	}
    @Column(name = "vendor_paytypev")
	public Integer getVendorPaytype() {
		return this.vendorPaytype;
	}

	public void setVendorPaytype(Integer vendorPaytype) {
		this.vendorPaytype = vendorPaytype;
	}
    @Column(name = "vendor_business_areaid")
	public Integer getVendorBusinessAreaid() {
		return this.vendorBusinessAreaid;
	}

	public void setVendorBusinessAreaid(Integer vendorBusinessAreaid) {
		this.vendorBusinessAreaid = vendorBusinessAreaid;
	}
    @Column(name = "vendor_default_accountid")
	public Integer getVendorDefaultAccountid() {
		return this.vendorDefaultAccountid;
	}

	public void setVendorDefaultAccountid(Integer vendorDefaultAccountid) {
		this.vendorDefaultAccountid = vendorDefaultAccountid;
	}
    @Column(name = "vendor_shophour_end")
	public Timestamp getVendorShophourEnd() {
		return this.vendorShophourEnd;
	}

	public void setVendorShophourEnd(Timestamp vendorShophourEnd) {
		this.vendorShophourEnd = vendorShophourEnd;
	}
	@Transient
	public String getVendorShophourStartString() {
		if(this.vendorShophourStart != null){
			return new SimpleDateFormat("HH:mm:ss").format(this.vendorShophourStart);
		}
		return "";
	}

	@Transient
	public String getVendorShophourEndString() {
		if(this.vendorShophourStart != null){
			return new SimpleDateFormat("HH:mm:ss").format(this.vendorShophourEnd);
		}
		return "";
	}

}