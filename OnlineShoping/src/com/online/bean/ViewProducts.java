package com.online.bean;

public class ViewProducts {
	private int productId;
	 private String productName;
	 private double productCost;
	 private int productAvail;
	public ViewProducts(int productId, String productName, double productCost, int productAvail) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productAvail = productAvail;
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public int getProductAvail() {
		return productAvail;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public void setProductAvail(int productAvail) {
		this.productAvail = productAvail;
	}
	@Override
	public String toString() {
		return "ViewProducts [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productAvail=" + productAvail + "]";
	}
	}
