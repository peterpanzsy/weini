package com.weini.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
// default package
import org.hibernate.annotations.GenericGenerator;

/**
 * TBoxpage entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_boxpage")
public class TBoxpage implements java.io.Serializable {

	// Fields

	private Integer boxpageId;
	private String boxpageTitle;
	private String boxpageTiptext;
	private String boxpageOneText;
	private String boxpageOnedesctext;
	private String boxpageThreetext;
	private String boxpageThreedesctext;
	private String boxpageFiveboxtext;
	private String boxpageFivedesctext;
	private Integer boxpageStatus;
	// Constructors

	/** default constructor */
	public TBoxpage() {
	}

	/** full constructor */
	public TBoxpage(String boxpageTitle, String boxpageTiptext,
			String boxpageOneText, String boxpageOnedesctext,
			String boxpageThreetext, String boxpageThreedesctext,
			String boxpageFiveboxtext, String boxpageFivedesctext,
			Integer boxpageStatus) {
		this.boxpageTitle = boxpageTitle;
		this.boxpageTiptext = boxpageTiptext;
		this.boxpageOneText = boxpageOneText;
		this.boxpageOnedesctext = boxpageOnedesctext;
		this.boxpageThreetext = boxpageThreetext;
		this.boxpageThreedesctext = boxpageThreedesctext;
		this.boxpageFiveboxtext = boxpageFiveboxtext;
		this.boxpageFivedesctext = boxpageFivedesctext;
		this.boxpageStatus = boxpageStatus;
	}


	// Property accessors
    @Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "boxpage_id")      
	public Integer getBoxpageId() {
		return this.boxpageId;
	}

	public void setBoxpageId(Integer boxpageId) {
		this.boxpageId = boxpageId;
	}
	@Column(name = "boxpage_title")
	public String getBoxpageTitle() {
		return this.boxpageTitle;
	}

	public void setBoxpageTitle(String boxpageTitle) {
		this.boxpageTitle = boxpageTitle;
	}
	@Column(name = "boxpage_tiptext")
	public String getBoxpageTiptext() {
		return this.boxpageTiptext;
	}

	public void setBoxpageTiptext(String boxpageTiptext) {
		this.boxpageTiptext = boxpageTiptext;
	}
	@Column(name = "boxpage_oneText")
	public String getBoxpageOneText() {
		return this.boxpageOneText;
	}

	public void setBoxpageOneText(String boxpageOneText) {
		this.boxpageOneText = boxpageOneText;
	}
	@Column(name = "boxpage_onedesctext")
	public String getBoxpageOnedesctext() {
		return this.boxpageOnedesctext;
	}

	public void setBoxpageOnedesctext(String boxpageOnedesctext) {
		this.boxpageOnedesctext = boxpageOnedesctext;
	}
	@Column(name = "boxpage_threetext")
	public String getBoxpageThreetext() {
		return this.boxpageThreetext;
	}

	public void setBoxpageThreetext(String boxpageThreetext) {
		this.boxpageThreetext = boxpageThreetext;
	}
	@Column(name = "boxpage_threedesctext")
	public String getBoxpageThreedesctext() {
		return this.boxpageThreedesctext;
	}

	public void setBoxpageThreedesctext(String boxpageThreedesctext) {
		this.boxpageThreedesctext = boxpageThreedesctext;
	}
	@Column(name = "boxpage_fiveboxtext")
	public String getBoxpageFiveboxtext() {
		return this.boxpageFiveboxtext;
	}

	public void setBoxpageFiveboxtext(String boxpageFiveboxtext) {
		this.boxpageFiveboxtext = boxpageFiveboxtext;
	}
	@Column(name = "boxpage_fivedesctext")
	public String getBoxpageFivedesctext() {
		return this.boxpageFivedesctext;
	}

	public void setBoxpageFivedesctext(String boxpageFivedesctext) {
		this.boxpageFivedesctext = boxpageFivedesctext;
	}
	@Column(name = "boxpage_status")
	public Integer getBoxpageStatus() {
		return this.boxpageStatus;
	}

	public void setBoxpageStatus(Integer boxpageStatus) {
		this.boxpageStatus = boxpageStatus;
	}
   @Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }  
}
