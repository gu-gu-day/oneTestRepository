package com.pigeon.shop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String remark;
	private Set orderforms = new HashSet(0);
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** minimal constructor */
	public Store(String account, String name, String password, String email,
			String phone) {
		this.account = account;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	/** full constructor */
	public Store(String account, String name, String password, String email,
			String phone, String remark, Set orderforms, Set products) {
		this.account = account;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.remark = remark;
		this.orderforms = orderforms;
		this.products = products;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}