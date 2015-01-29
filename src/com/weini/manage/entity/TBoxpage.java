package com.weini.manage.entity;
// default package

/**
 * TBoxpage entity. @author MyEclipse Persistence Tools
 */

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

	// Constructors

	/** default constructor */
	public TBoxpage() {
	}

	/** full constructor */
	public TBoxpage(String boxpageTitle, String boxpageTiptext,
			String boxpageOneText, String boxpageOnedesctext,
			String boxpageThreetext, String boxpageThreedesctext,
			String boxpageFiveboxtext, String boxpageFivedesctext) {
		this.boxpageTitle = boxpageTitle;
		this.boxpageTiptext = boxpageTiptext;
		this.boxpageOneText = boxpageOneText;
		this.boxpageOnedesctext = boxpageOnedesctext;
		this.boxpageThreetext = boxpageThreetext;
		this.boxpageThreedesctext = boxpageThreedesctext;
		this.boxpageFiveboxtext = boxpageFiveboxtext;
		this.boxpageFivedesctext = boxpageFivedesctext;
	}

	// Property accessors

	public Integer getBoxpageId() {
		return this.boxpageId;
	}

	public void setBoxpageId(Integer boxpageId) {
		this.boxpageId = boxpageId;
	}

	public String getBoxpageTitle() {
		return this.boxpageTitle;
	}

	public void setBoxpageTitle(String boxpageTitle) {
		this.boxpageTitle = boxpageTitle;
	}

	public String getBoxpageTiptext() {
		return this.boxpageTiptext;
	}

	public void setBoxpageTiptext(String boxpageTiptext) {
		this.boxpageTiptext = boxpageTiptext;
	}

	public String getBoxpageOneText() {
		return this.boxpageOneText;
	}

	public void setBoxpageOneText(String boxpageOneText) {
		this.boxpageOneText = boxpageOneText;
	}

	public String getBoxpageOnedesctext() {
		return this.boxpageOnedesctext;
	}

	public void setBoxpageOnedesctext(String boxpageOnedesctext) {
		this.boxpageOnedesctext = boxpageOnedesctext;
	}

	public String getBoxpageThreetext() {
		return this.boxpageThreetext;
	}

	public void setBoxpageThreetext(String boxpageThreetext) {
		this.boxpageThreetext = boxpageThreetext;
	}

	public String getBoxpageThreedesctext() {
		return this.boxpageThreedesctext;
	}

	public void setBoxpageThreedesctext(String boxpageThreedesctext) {
		this.boxpageThreedesctext = boxpageThreedesctext;
	}

	public String getBoxpageFiveboxtext() {
		return this.boxpageFiveboxtext;
	}

	public void setBoxpageFiveboxtext(String boxpageFiveboxtext) {
		this.boxpageFiveboxtext = boxpageFiveboxtext;
	}

	public String getBoxpageFivedesctext() {
		return this.boxpageFivedesctext;
	}

	public void setBoxpageFivedesctext(String boxpageFivedesctext) {
		this.boxpageFivedesctext = boxpageFivedesctext;
	}

}