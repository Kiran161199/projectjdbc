package com.online.persistance;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.online.helper.OracleConnection;
import com.online.bean.BuyingProducts;
import com.online.bean.OnlineShoping;
import com.online.bean.ViewProducts;


public class OnlineDaoImpl implements OnlineDao{
	@Override
	public int signUp(OnlineShoping onlineShoping) throws ClassNotFoundException, SQLException {
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO LOGIN(USERNAME,PASSWORD,PHONE_NO) VALUES(?,?,?)");
		
		
		preparedStatement.setString(1, onlineShoping.getUserName());
		preparedStatement.setString(2, onlineShoping.getPassword());
		preparedStatement.setLong(3, onlineShoping.getNumber());
		
		int rows=preparedStatement.executeUpdate();

		return rows;
	
	}
	
	@Override
	public int signIn(String userName,String passWord,long phone) throws ClassNotFoundException, SQLException {

		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM LOGIN WHERE USERNAME=? AND PHONE_NO=? AND PASSWORD=?");
		preparedStatement.setString(1, userName);
		preparedStatement.setLong(2, phone);
		preparedStatement.setString(3, passWord);
		
		int rows=preparedStatement.executeUpdate();

		return rows;
		
	}
	@Override
	public List<ViewProducts> getAllProducts() throws ClassNotFoundException, SQLException {
			List<ViewProducts> viewProducts=new ArrayList<ViewProducts>();
			Connection connection = OracleConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int pId = resultSet.getInt("PRODUCT_ID");
				String pName = resultSet.getString("PRODUCT_NAME");
				int pCost = resultSet.getInt("PRODUCT_COST");
				ViewProducts Shoping=new ViewProducts(pId,pName,pCost);
				viewProducts.add(Shoping);
			}

			connection.close();

			return viewProducts;
		}
		
	
	@Override
	public  BuyingProducts buyingProducts(String buyproduct) throws ClassNotFoundException, SQLException {
		BuyingProducts buyprod=null;
		Connection connection=OracleConnection.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PRODUCTS WHERE PRODUCT_NAME=?");
		preparedStatement.setString(1, buyproduct);
ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			int prodId=resultSet.getInt("PRODUCT_ID");
			String prodName=resultSet.getString("PRODUCT_Name");
			int prodCost=resultSet.getInt("PRODUCT_cost");
			buyprod=new BuyingProducts(prodName,prodId,prodCost);
		
		}

		connection.close();
		return buyprod;
	}

	

}
