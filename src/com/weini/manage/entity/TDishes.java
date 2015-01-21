package com.weini.manage.entity;
// default package

/**
 * TDishes entity. @author MyEclipse Persistence Tools
 */

public class TDishes implements java.io.Serializable {

	// Fields

	private Integer dishesId;
	private String dishesName;
	private String dishesSeries1;
	private String dishesSeries2;

	// Constructors

	/** default constructor */
	public TDishes() {
	}

	/** full constructor */
	public TDishes(String dishesName, String dishesSeries1, String dishesSeries2) {
		this.dishesName = dishesName;
		this.dishesSeries1 = dishesSeries1;
		this.dishesSeries2 = dishesSeries2;
	}

	// Property accessors

	public Integer getDishesId() {
		return this.dishesId;
	}

	public void setDishesId(Integer dishesId) {
		this.dishesId = dishesId;
	}

	public String getDishesName() {
		return this.dishesName;
	}

	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}

	public String getDishesSeries1() {
		return this.dishesSeries1;
	}

	public void setDishesSeries1(String dishesSeries1) {
		this.dishesSeries1 = dishesSeries1;
	}

	public String getDishesSeries2() {
		return this.dishesSeries2;
	}

	public void setDishesSeries2(String dishesSeries2) {
		this.dishesSeries2 = dishesSeries2;
	}

}