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
	Scanner scanner=new Scanner(System.in);
	@Override
	public void showMenu() {
		System.out.println("1.Register new user");
		System.out.println("2. sign in for already register users ");
		System.out.println("3.Exit");

	}

	@Override
	public void performMenu(int choice){

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
				System.out.println("Enter Login User Name : ");
				String userName = scanner.next();

				System.out.println("Enter Login Password : ");
				String passWord = scanner.next();

				System.out.println("Enter Login Phone : ");
				long phone = scanner.nextLong();

				if(onlineService.signIn(userName, passWord, phone))
				{
					System.out.println("sign in sucessfully");
					System.out.println("-----------------------------------------------------");
					System.out.println("1.View products");
					System.out.println("2.Buy products");

					System.out.println("Enter your choice");
					int ch= scanner.nextInt();
					switch(ch) {
					case 1:
						try {
							System.out.println("list of Products are:");
							List<ViewProducts> onlineShoping=onlineService.viewAllProducts();
							for(ViewProducts online:onlineShoping) {
								System.out.println(online);

							}

							System.out.println("Enter the product name to buy");
							String productName=scanner.next();
							System.out.println("Enter the cost of product");
							int productcost=scanner.nextInt();
							if(onlineService.getDetailsByName(productName,productcost)) {
								System.out.println(productName+"\t"+"BUYED SUCCESSFULLY");

								ProductBillPay productBillPay = onlineService.genrateProductBill(productName);

								if (productBillPay != null)
									System.out.println(productBillPay);
								else
									System.out.println("Product with Product Name " + productName + " does not exist");
							}	
							else
								System.out.println("Buying Failed");
						}
						catch(ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						try {

							System.out.println("list of Products are:");
							List<ViewProducts> onlineShoping=onlineService.viewAllProducts();
							for(ViewProducts online:onlineShoping) {
								System.out.println(online);}
							System.out.println("Enter the product name to buy");
							String productName=scanner.next();
							System.out.println("Enter the cost of product");
							int productcost=scanner.nextInt();
							if(onlineService.getDetailsByName(productName,productcost)) {
								System.out.println(productName+"\t"+"BUYED SUCCESSFULLY");

								ProductBillPay productBillPay = onlineService.genrateProductBill(productName);

								if (productBillPay != null)
									System.out.println(productBillPay);
								else
									System.out.println("Product with Product Name " + productName + " does not exist");
							}	
							else
								System.out.println("Buying Failed");
						}
						catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						break;

					}
				}	
				else
					System.out.println("sign in  Failed!");
			}
			catch (ClassNotFoundException | SQLException e) {
				System.out.println("sign in Failed!");
			}
			break;


		case 3:
			System.out.println("Invalid choice");
		}

	}

}



