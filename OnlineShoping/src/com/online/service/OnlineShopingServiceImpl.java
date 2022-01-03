package com.online.service;

import java.sql.SQLException;
import java.util.List;

import com.online.bean.BuyingProducts;
import com.online.bean.OnlineShoping;
import com.online.bean.ProductBillPay;
import com.online.bean.ViewProducts;
import com.online.persistance.OnlineDao;
import com.online.persistance.OnlineDaoImpl;

public class OnlineShopingServiceImpl implements OnlineShopingServiceDao {
	private OnlineDao onlineDao=new OnlineDaoImpl();
	
	@Override
	public boolean registerUser(OnlineShoping onlineShoping) throws ClassNotFoundException, SQLException {
		int rows=onlineDao.signUp(onlineShoping);
		if(rows>0)
			return true;
		return false;
	}
	@Override
	public boolean signIn(String userName, String passWord, long phone) throws ClassNotFoundException, SQLException {
		int rows=onlineDao.signIn(userName, passWord, phone);
		if(rows>0)
			return true;
		return false; 
	}
	@Override
	public List<ViewProducts> viewAllProducts() throws ClassNotFoundException, SQLException {
		
		return onlineDao.getAllProducts();
	}
	
	@Override
	public boolean getDetailsByName(String product_name,int product_cost) throws ClassNotFoundException, SQLException {
		int rows=onlineDao.buyingProducts(product_name, product_cost);
		if(rows>0)
		return true;
		return false;
	}
	@Override
	public BuyingProducts getProductByName(String pName) throws ClassNotFoundException, SQLException {
		return onlineDao.getProductByName(pName);
	}
	@Override
	public ProductBillPay genrateProductBill(String pName) throws ClassNotFoundException, SQLException {
		BuyingProducts onlineShopingProducts=onlineDao.getProductByName(pName);

		ProductBillPay productBillPay=null;
		if(onlineShopingProducts!=null) {
			double gst=onlineShopingProducts.getProdcost()*.15;
			double total=onlineShopingProducts.getProdcost()+gst;
			productBillPay=new ProductBillPay(onlineShopingProducts, gst, total);
		}
		return productBillPay;
	}
	
	
}
