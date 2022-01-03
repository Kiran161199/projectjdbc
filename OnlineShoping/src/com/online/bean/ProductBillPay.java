package com.online.bean;
public class ProductBillPay {
	private BuyingProducts buyingProduct ;
	private double gst;
	private double total;

	public ProductBillPay() {

	}



	public ProductBillPay(BuyingProducts buyingProduct, double gst, double total) {
		super();
		this.buyingProduct = buyingProduct;
		this.gst = gst;
		this.total = total;
	}



	public BuyingProducts getBuyingProduct() {
		return buyingProduct;
	}



	public void setBuyingProduct(BuyingProducts buyingProduct) {
		this.buyingProduct = buyingProduct;
	}



	public double getGst() {
		return gst;
	}



	public void setGst(double gst) {
		this.gst = gst;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "ProductBillPay [buyingProduct=" + buyingProduct + ", gst=" + gst + ", total=" + total + "]";
	}






}