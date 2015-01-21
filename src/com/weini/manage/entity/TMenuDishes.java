package com.weini.manage.entity;
// default package

/**
 * TMenuDishes entity. @author MyEclipse Persistence Tools
 */

public class TMenuDishes implements java.io.Serializable {

	// Fields

	private Integer menuDishesId;
	private Integer menuinfoId;
	private Integer dishesId;

	// Constructors

	/** default constructor */
	public TMenuDishes() {
	}

	/** full constructor */
	public TMenuDishes(Integer menuinfoId, Integer dishesId) {
		this.menuinfoId = menuinfoId;
		this.dishesId = dishesId;
	}

	// Property accessors

	public Integer getMenuDishesId() {
		return this.menuDishesId;
	}

	public void setMenuDishesId(Integer menuDishesId) {
		this.menuDishesId = menuDishesId;
	}

	public Integer getMenuinfoId() {
		return this.menuinfoId;
	}

	public void setMenuinfoId(Integer menuinfoId) {
		this.menuinfoId = menuinfoId;
	}

	public Integer getDishesId() {
		return this.dishesId;
	}

	public void setDishesId(Integer dishesId) {
		this.dishesId = dishesId;
	}

}