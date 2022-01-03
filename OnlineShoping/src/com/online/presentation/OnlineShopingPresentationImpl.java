package com.online.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.online.bean.BuyingProducts;
import com.online.bean.OnlineShoping;
import com.online.bean.ProductBillPay;
import com.online.bean.ViewProducts;
import com.online.service.OnlineShopingServiceDao;
import com.online.service.OnlineShopingServiceImpl;

public class OnlineShopingPresentationImpl implements OnlineShopingPresentationDao {
	private OnlineShopingServiceDao onlineService=new OnlineShopingServiceImpl();
	@Override
	public void showMenu() {
		System.out.println("1.Register new user");
		System.out.println("2. sign in for already register users ");
		System.out.println("3.Exit");
		
	}

	@Override
	public void performMenu(int choice){
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1:
			try {
				System.out.println("Enter User Name : ");
				String name = scanner.next();
				System.out.println("Enter Password : ");
				String password = scanner.next();
				System.out.println("Enter Phone number : ");
				long number = scanner.nextLong();
				OnlineShoping online=new OnlineShoping(name, password, number);
				if(onlineService.registerUser(online)) {
					System.out.println("User Registered successfully!");
				}
				else
					System.out.println("User Registration Failed!");
				}
			catch (ClassNotFoundException | SQLException e) {
				System.out.println("User Registration  Failed!");
			}
			break;
			
		case 2:
			try {
			System.out.println("Enter login user name : ");
			String userName = scanner.next();
			System.out.println("Enter login phone : ");
			long phone = scanner.nextLong();
			System.out.println("Enter login password : ");
			String passWord = scanner.next();
			
			
			if(onlineService.signIn(userName, passWord, phone))
			{
				System.out.println("sign in sucessfully");
			}	
			else
				System.out.println("sign in  Failed!");
			}
			catch (ClassNotFoundException | SQLException e) {
				System.out.println("sign in Failed!");
			}
			break;
			
		
		case 3:
			System.out.println("User Exited");
		}
		
	}

	@Override
	public void showSubMenu() {
		System.out.println("1.View products");
		System.out.println("2.Buy products");
		System.out.println("4.logout");
		
	}

	@Override
	public void performSubMenu(int ch) {
		switch(ch) {
		case 1:
			try {
				System.out.println("list of Products are:");
				List<ViewProducts> onlineShoping=onlineService.viewAllProducts();
				for(ViewProducts online:onlineShoping) {
					System.out.println(online);
				}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		case 2:
			try {
				Scanner scanner=new Scanner(System.in);
				System.out.println("Enter the product to buy");
				String productName=scanner.next();
				BuyingProducts buyproducts= onlineService.getDetailsByName(productName);
				if(productName!=null) {
					System.out.println(buyproducts);
					System.out.println(productName+"\t"+"BUYED SUCCESSFULLY");
				}
				else
					System.out.println("Buying Failed");
			}
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		case 3:
			try {
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("Enter Product Name which product payslip you want to view: ");
				String pName = scanner1.next();

				ProductBillPay productBillPay = onlineService.generateProductPayslipByPname(pName);

				if (productBillPay != null)
					System.out.println(productBillPay);
				else
					System.out.println("Product with Product Name " + pName + " does not exist");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Product with Product Name  does not exist");
			}
			break;
		case 4:
			System.out.println("log out");
			break;
			
		}
		
	}

	
}





