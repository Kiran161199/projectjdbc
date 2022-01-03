package com.online.service;

import java.sql.SQLException;
import java.util.List;

import com.online.bean.BuyingProducts;
import com.online.bean.OnlineShoping;
import com.online.bean.ProductBillPay;
import com.online.bean.ViewProducts;

public interface OnlineShopingServiceDao {
	public boolean registerUser(OnlineShoping onlineShoping) throws ClassNotFoundException, SQLException;
	public boolean signIn(String userName,String passWord,long phone)throws ClassNotFoundException,SQLException;
	List<ViewProducts> viewAllProducts()throws ClassNotFoundException,SQLException;
	public boolean getDetailsByName(String product_name,int product_cost) throws ClassNotFoundException, SQLException;
	BuyingProducts getProductByName(String pName)throws ClassNotFoundException,SQLException;
	ProductBillPay genrateProductBill(String pName)throws ClassNotFoundException,SQLException;
}
