package com.pigeon.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private Producttype producttype;
	private Store store;
	private Productclass productclass;
	private String name;
	private Integer remainingNumber;
	private Double price;
	private String introduction;
	private String picture;
	private String state;
	private String remark;
	private Set orderforms = new HashSet(0);
	private Set carts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Producttype producttype, Productclass productclass,
			String name, Integer remainingNumber, Double price) {
		this.producttype = producttype;
		this.productclass = productclass;
		this.name = name;
		this.remainingNumber = remainingNumber;
		this.price = price;
	}

	/** full constructor */
	public Product(Producttype producttype, Store store,
			Productclass productclass, String name, Integer remainingNumber,
			Double price, String introduction, String picture, String state,
			String remark, Set orderforms, Set carts) {
		this.producttype = producttype;
		this.store = store;
		this.productclass = productclass;
		this.name = name;
		this.remainingNumber = remainingNumber;
		this.price = price;
		this.introduction = introduction;
		this.picture = picture;
		this.state = state;
		this.remark = remark;
		this.orderforms = orderforms;
		this.carts = carts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producttype getProducttype() {
		return this.producttype;
	}

	public void setProducttype(Producttype producttype) {
		this.producttype = producttype;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Productclass getProductclass() {
		return this.productclass;
	}

	public void setProductclass(Productclass productclass) {
		this.productclass = productclass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRemainingNumber() {
		return this.remainingNumber;
	}

	public void setRemainingNumber(Integer remainingNumber) {
		this.remainingNumber = remainingNumber;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getOrderforms() {
		return this.orderforms;
	}

	public void setOrderforms(Set orderforms) {
		this.orderforms = orderforms;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}