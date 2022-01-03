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
	public BuyingProducts getDetailsByName(String product_name) throws ClassNotFoundException, SQLException {
		return onlineDao.buyingProducts(product_name);
	}
	
	
	@Override
	public ProductBillPay generateProductPayslipByPname(String productName) throws ClassNotFoundException, SQLException {

		BuyingProducts onlineShopingProducts=onlineDao.buyingProducts(productName);

		ProductBillPay productBillPay=null;
		if(onlineShopingProducts!=null) {
			double gst=onlineShopingProducts.getProductCost()*.15;
			double total=onlineShopingProducts.getProductCost()+gst;
			productBillPay=new ProductBillPay(onlineShopingProducts, gst, total);
		}
		return productBillPay;
	}
}
