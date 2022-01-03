package com.online.client;

import java.util.Scanner;

import com.online.presentation.OnlineShopingPresentationDao;
import com.online.presentation.OnlineShopingPresentationImpl;

public class OnlineShopingClient {
public static void main(String[] args) {
	
	OnlineShopingPresentationDao onlineShopingPresentation=new OnlineShopingPresentationImpl();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			onlineShopingPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
		onlineShopingPresentation.performMenu(choice);
	System.out.println("----------------------------------------------");
	if(choice==2) {
		onlineShopingPresentation.showSubMenu();
		System.out.println("Enter Choice : ");
		int ch=scanner.nextInt();
	onlineShopingPresentation.performSubMenu(ch);
	}
		}
}
}




