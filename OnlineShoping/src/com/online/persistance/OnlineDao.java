package com.online.persistance;

import java.sql.SQLException;
import java.util.List;

import com.online.bean.BuyingProducts;
import com.online.bean.OnlineShoping;
import com.online.bean.ViewProducts;
public interface OnlineDao {
	 int signUp(OnlineShoping onlineShoping)throws ClassNotFoundException,SQLException;
	 int signIn(String userName,String passWord,long phone)throws ClassNotFoundException,SQLException;
	List<ViewProducts> getAllProducts()throws ClassNotFoundException,SQLException;
	BuyingProducts getProductByName(String pName)throws ClassNotFoundException,SQLException;
	int buyingProducts(String productName,int productcost)throws ClassNotFoundException,SQLException;
}
