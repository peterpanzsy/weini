package com.weini.manage.entity;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
// default package
import org.hibernate.annotations.GenericGenerator;

/**
 * TDishes entity. @author MyEclipse Persistence Tools
 */
@Entity   
@Table(name="t_dishes")
public class TDishes implements java.io.Serializable {

	// Fields

	private Integer dishesId;
	private String dishesName;
	private String dishesSeries1;
	private String dishesSeries2;
	//pl add
	private String dishesWeight;

	// Constructors

	/** default constructor */
	public TDishes() {
	}

	/** minimal constructor */
	public TDishes(String dishesName) {
		this.dishesName = dishesName;
	}

	/** full constructor */
	public TDishes(String dishesName, String dishesSeries1, String dishesSeries2) {
		this.dishesName = dishesName;
		this.dishesSeries1 = dishesSeries1;
		this.dishesSeries2 = dishesSeries2;
	}

	// Property accessors
	@Id              // 表示主键
    @GenericGenerator(name = "generator", strategy = "increment")  
    @GeneratedValue(generator = "generator")   // 自增长
    @Column(name = "dishes_id") 
	public Integer getDishesId() {
		return this.dishesId;
	}

	public void setDishesId(Integer dishesId) {
		this.dishesId = dishesId;
	}
	@Column(name = "dishes_name")
	public String getDishesName() {
		return this.dishesName;
	}

	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}
	@Column(name = "dishes_series_1")
	public String getDishesSeries1() {
		return this.dishesSeries1;
	}

	public void setDishesSeries1(String dishesSeries1) {
		this.dishesSeries1 = dishesSeries1;
	}
	@Column(name = "dishes_series_2")
	public String getDishesSeries2() {
		return this.dishesSeries2;
	}

	public void setDishesSeries2(String dishesSeries2) {
		this.dishesSeries2 = dishesSeries2;
	}
	@Override  
    public String toString() {  
        //两种方式都可以  
        //return ReflectionToStringBuilder.toString(this);  
        return ToStringBuilder.reflectionToString(this);  
    }
	@Transient
	public String getDishesWeight() {
		return dishesWeight;
	}

	public void setDishesWeight(String dishesWeight) {
		this.dishesWeight = dishesWeight;
	}
}