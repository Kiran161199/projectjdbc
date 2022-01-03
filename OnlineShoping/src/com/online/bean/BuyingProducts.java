package com.online.bean;

public class BuyingProducts {
	private String product_name;
	private int productId;
	public BuyingProducts() {
		
	}
	@Override
	public String toString() {
		return "BuyingProducts [product_name=" + product_name + ", productId=" + productId + ", productCost="
				+ productCost + "]";
	}

	public BuyingProducts(String product_name, int productId, int productCost) {
		super();
		this.product_name = product_name;
		this.productId = productId;
		this.productCost = productCost;
	}

	public int getProductId() {
		return productId;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	private int productCost;

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
}
