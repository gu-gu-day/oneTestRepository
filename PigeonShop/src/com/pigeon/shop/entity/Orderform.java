package com.pigeon.shop.entity;

/**
 * Orderform entity. @author MyEclipse Persistence Tools
 */

public class Orderform implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Product product;
	private Store store;
	private Integer buyNumber;
	private Double moneyAmount;
	private String state;
	private String remark;

	// Constructors

	/** default constructor */
	public Orderform() {
	}

	/** minimal constructor */
	public Orderform(User user, Product product, Store store,
			Integer buyNumber, Double moneyAmount, String state) {
		this.user = user;
		this.product = product;
		this.store = store;
		this.buyNumber = buyNumber;
		this.moneyAmount = moneyAmount;
		this.state = state;
	}

	/** full constructor */
	public Orderform(User user, Product product, Store store,
			Integer buyNumber, Double moneyAmount, String state, String remark) {
		this.user = user;
		this.product = product;
		this.store = store;
		this.buyNumber = buyNumber;
		this.moneyAmount = moneyAmount;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getBuyNumber() {
		return this.buyNumber;
	}

	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}

	public Double getMoneyAmount() {
		return this.moneyAmount;
	}

	public void setMoneyAmount(Double moneyAmount) {
		this.moneyAmount = moneyAmount;
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

}