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
 * TBox entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_box")
public class TBox implements java.io.Serializable {

	// Fields

	private Integer boxId;
	private Integer boxGender;
	private Float boxPrice;
	private Integer boxCityid;
	private String boxImage1;
	private String boxdesc1;
	private String boxdesc2;
	private String boxdesc3;
	private String boxdesc4;
	private String boxtypename;
	private Integer boxtype;
	// Constructors

	/** default constructor */
	public TBox() {
	}

	/** full constructor */
	

	// Property accessors

	public TBox(Integer boxGender, Float boxPrice, Integer boxCityid,
			String boxImage1, String boxdesc1, String boxdesc2,
			String boxdesc3, String boxdesc4, String boxtypename,
			Integer boxtype) {
		super();
		this.boxGender = boxGender;
		this.boxPrice = boxPrice;
		this.boxCityid = boxCityid;
		this.boxImage1 = boxImage1;
		this.boxdesc1 = boxdesc1;
		this.boxdesc2 = boxdesc2;
		this.boxdesc3 = boxdesc3;
		this.boxdesc4 = boxdesc4;
		this.boxtypename = boxtypename;
		this.boxtype = boxtype;
	}

	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "box_id")    
	public Integer getBoxId() {
		return this.boxId;
	}


	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	@Column(name = "box_gender")
	public Integer getBoxGender() {
		return this.boxGender;
	}

	public void setBoxGender(Integer boxGender) {
		this.boxGender = boxGender;
	}
	@Column(name = "box_price")
	public Float getBoxPrice() {
		return this.boxPrice;
	}

	public void setBoxPrice(Float boxPrice) {
		this.boxPrice = boxPrice;
	}
	@Column(name = "box_cityid")
	public Integer getBoxCityid() {
		return this.boxCityid;
	}

	public void setBoxCityid(Integer boxCityid) {
		this.boxCityid = boxCityid;
	}
	@Column(name = "box_image1")
	public String getBoxImage1() {
		return this.boxImage1;
	}
	
	public void setBoxImage1(String boxImage1) {
		this.boxImage1 = boxImage1;
	}

   @Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }
	@Column(name = "box_type")
	public Integer getBoxtype() {
		return boxtype;
	}

	public void setBoxtype(Integer boxtype) {
		this.boxtype = boxtype;
	}
	@Column(name = "box_desc1")
	public String getBoxdesc1() {
		return boxdesc1;
	}

	public void setBoxdesc1(String boxdesc1) {
		this.boxdesc1 = boxdesc1;
	}
	@Column(name = "box_desc2")
	public String getBoxdesc2() {
		return boxdesc2;
	}

	public void setBoxdesc2(String boxdesc2) {
		this.boxdesc2 = boxdesc2;
	}
	@Column(name = "box_desc3")
	public String getBoxdesc3() {
		return boxdesc3;
	}
	
	public void setBoxdesc3(String boxdesc3) {
		this.boxdesc3 = boxdesc3;
	}
	@Column(name = "box_desc4")
	public String getBoxdesc4() {
		return boxdesc4;
	}

	public void setBoxdesc4(String boxdesc4) {
		this.boxdesc4 = boxdesc4;
	}
	@Column(name = "box_typename")
	public String getBoxtypename() {
		return boxtypename;
	}

	public void setBoxtypename(String boxtypename) {
		this.boxtypename = boxtypename;
	} 

}
