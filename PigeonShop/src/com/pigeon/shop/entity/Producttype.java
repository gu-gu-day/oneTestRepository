package com.pigeon.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Producttype entity. @author MyEclipse Persistence Tools
 */

public class Producttype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Productclass productclass;
	private String typeName;
	private String remark;
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Producttype() {
	}

	/** minimal constructor */
	public Producttype(Productclass productclass, String typeName) {
		this.productclass = productclass;
		this.typeName = typeName;
	}

	/** full constructor */
	public Producttype(Productclass productclass, String typeName,
			String remark, Set products) {
		this.productclass = productclass;
		this.typeName = typeName;
		this.remark = remark;
		this.products = products;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Productclass getProductclass() {
		return this.productclass;
	}

	public void setProductclass(Productclass productclass) {
		this.productclass = productclass;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}