package com.weini.manage.entity;
// default package

/**
 * TPoint entity. @author MyEclipse Persistence Tools
 */

public class TPoint implements java.io.Serializable {

	// Fields

	private Integer pointId;
	private Integer userId;
	private Integer pointFirst;
	private Integer pointActivity;
	private Integer pointConfirm;
	private Integer pointExpenditure;
	private Integer pointTotal;

	// Constructors

	/** default constructor */
	public TPoint() {
	}

	/** minimal constructor */
	public TPoint(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TPoint(Integer userId, Integer pointFirst, Integer pointActivity,
			Integer pointConfirm, Integer pointExpenditure, Integer pointTotal) {
		this.userId = userId;
		this.pointFirst = pointFirst;
		this.pointActivity = pointActivity;
		this.pointConfirm = pointConfirm;
		this.pointExpenditure = pointExpenditure;
		this.pointTotal = pointTotal;
	}

	// Property accessors

	public Integer getPointId() {
		return this.pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPointFirst() {
		return this.pointFirst;
	}

	public void setPointFirst(Integer pointFirst) {
		this.pointFirst = pointFirst;
	}

	public Integer getPointActivity() {
		return this.pointActivity;
	}

	public void setPointActivity(Integer pointActivity) {
		this.pointActivity = pointActivity;
	}

	public Integer getPointConfirm() {
		return this.pointConfirm;
	}

	public void setPointConfirm(Integer pointConfirm) {
		this.pointConfirm = pointConfirm;
	}

	public Integer getPointExpenditure() {
		return this.pointExpenditure;
	}

	public void setPointExpenditure(Integer pointExpenditure) {
		this.pointExpenditure = pointExpenditure;
	}

	public Integer getPointTotal() {
		return this.pointTotal;
	}

	public void setPointTotal(Integer pointTotal) {
		this.pointTotal = pointTotal;
	}

}