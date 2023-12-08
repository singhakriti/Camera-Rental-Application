package com.camerarental.utility;

import java.util.Scanner;

import com.camerarental.bean.User;
import com.camerarental.service.CameraService;

public class CameraRentalUtility {
	static Scanner sc = new Scanner(System.in);
	public static void login(){
		System.out.println("Enter your email id");
		String emailid = sc.next();
		System.out.println("Eneter your password");
		String password = sc.next();
		if(emailid.equals("akriti") && password.equals("12345")) {
			System.out.println("Successfully login");
			User user=new User(emailid, 20000);
			CameraService cs = new CameraService();
			mainOption(user, cs);
		}else {
			System.out.println("Failure try once again");
			login();
		}
	}
		private static void mainOption(User user, CameraService cs) {
			int choice;
			String con="";
			do {
				System.out.println("1: My Camera");
				System.out.println("2: Rent Camera");
				System.out.println("3: View All Camera");
				System.out.println("4: My Wallet");
				System.out.println("5: Exit");
				System.out.println("Plz enter your choice");
				choice = sc.nextInt();
				switch(choice) {
				case 1: subMenuOption(user, cs);
					break;
				case 2: rentACamera(user, cs);
					break;
				case 3: cs.viewAllCamera();
					break;
				case 4: getWalletBal(user);
					break;
				case 5: 
					break;
				default:System.out.println("Wrong choice");
				break;
				}
				System.out.println("Do you want to continue(y/n)");
				con = sc.next();
			}while(con.equalsIgnoreCase("y"));
		}
		
		private static void subMenuOption(User user, CameraService cs) {
			int choice;
			String con="";
			do {
				System.out.println("1: Add Camera");
				System.out.println("2: Remove Camera");
				System.out.println("3: View Camere details");
				System.out.println("4: Go to previous menu");
				choice = sc.nextInt();
				switch(choice) {
				case 1: cs.addCamera();
					break;
				case 2: cs.removeCamera();
					break;
				case 3: cs.viewAllCamera();
					break;
				case 4: mainOption(user, cs);
					break;
				default:System.out.println("Wrong choice");
				break;
				}
				System.out.println("Do you want to continue(y/n)");
				con = sc.next();
			}while(con.equalsIgnoreCase("y"));
	}
		private static void rentACamera(User user, CameraService cs) {
			cs.viewAllAvailableCamera();
			System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT:");
			int id = sc.nextInt();
			cs.rentCamera(id, user);
			
		}
		
		private static void getWalletBal(User user) {
			System.out.println("YOUR CURRENT WALLET BALANCE IS - INR. " + user.getWalletBalance());
			System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO) - ");
			int opt=sc.nextInt();
			if(opt==1) {
				System.out.println("ENTER THE AMOUNT (INR) - ");
				float amount=sc.nextInt();
				user.setWalletBalance(user.getWalletBalance()+amount);
				System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR. " 
						+ user.getWalletBalance());
			}
		}
		

	}


