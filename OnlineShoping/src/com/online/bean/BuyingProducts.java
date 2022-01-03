package com.online.bean;

public class BuyingProducts {
	public BuyingProducts() {
		
	}
	private String product_name;
	private int productId;
	private int prodcost;
	private int productAvail;
	public BuyingProducts(String product_name, int productId, int prodcost, int productAvail) {
		super();
		this.product_name = product_name;
		this.productId = productId;
		this.prodcost = prodcost;
		this.productAvail = productAvail;
	}
	public String getProduct_name() {
		return product_name;
	}
	public int getProductId() {
		return productId;
	}
	public int getProdcost() {
		return prodcost;
	}
	public int getProductAvail() {
		return productAvail;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProdcost(int prodcost) {
		this.prodcost = prodcost;
	}
	public void setProductAvail(int productAvail) {
		this.productAvail = productAvail;
	}
	@Override
	public String toString() {
		return "BuyingProducts [product_name=" + product_name + ", productId=" + productId + ", prodcost=" + prodcost
				+ ", productAvail=" + productAvail + "]";
	}
	
	
}
