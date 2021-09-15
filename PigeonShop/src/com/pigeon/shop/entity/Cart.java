package com.pigeon.shop.entity;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer id;
	private Product product;
	private User user;
	private Double price;
	private Integer buyNumber;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Product product, User user, Double price, Integer buyNumber) {
		this.product = product;
		this.user = user;
		this.price = price;
		this.buyNumber = buyNumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getBuyNumber() {
		return this.buyNumber;
	}

	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}

}