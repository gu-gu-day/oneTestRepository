package com.pigeon.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Productclass entity. @author MyEclipse Persistence Tools
 */

public class Productclass implements java.io.Serializable {

	// Fields

	private Integer id;
	private String className;
	private String remark;
	private Set producttypes = new HashSet(0);
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Productclass() {
	}

	/** minimal constructor */
	public Productclass(String className) {
		this.className = className;
	}

	/** full constructor */
	public Productclass(String className, String remark, Set producttypes,
			Set products) {
		this.className = className;
		this.remark = remark;
		this.producttypes = producttypes;
		this.products = products;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getProducttypes() {
		return this.producttypes;
	}

	public void setProducttypes(Set producttypes) {
		this.producttypes = producttypes;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}