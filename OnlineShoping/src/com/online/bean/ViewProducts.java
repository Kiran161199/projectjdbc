package com.online.bean;

public class ViewProducts {
	private int productId;
	 private String productName;
	 private double productCost;
	public ViewProducts(int productId, String productName, double productCost) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
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
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	@Override
	public String toString() {
		return "ViewProducts [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ "]";
	}
}
