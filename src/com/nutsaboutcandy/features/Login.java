package com.nutsaboutcandy.features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.nutsaboutcandy.NutsAboutCandy;
import com.nutsaboutcandy.features.Inventory;

	public class Login {
		
		static Scanner userInput = new Scanner(System.in);
		static String username;
		
		public void doLogin() {
			boolean userLogin = false;
			while(!userLogin) {
				System.out.print("\n----------------------------------------------" +
						 		 "\n\tNuts About Candy Online Store" +
						 		 "\n----------------------------------------------" +
								 "\nLogin First.");
				System.out.print("\nUsername: ");		 		 
				username = userInput.next();
				System.out.print("Password: ");		 		 
				String password = userInput.next();
					if(username.equals("admin") && password.equals("admin")) {
						userLogin = true;
					} else {
						System.out.print("Incorrect username and password. Try Again!");
					}
			}
		}
		
		
		@SuppressWarnings({ "unchecked", "static-access", "rawtypes" })
		public void doStartMenu(ArrayList nac_database) {
			
			boolean chooseActivity = false;
			while(!chooseActivity) {
				System.out.print("\n----------------------------------------------" +
								 "\n\t\tWelcome " + username);
				System.out.print("\n----------------------------------------------");
				System.out.print("\n[1] Inventory" +
								 "\n[2] Shopping Cart" +
								 "\n[3] Cashier" + 
								 "\n[4] Logout" +
								 "\n--> ");
				int choice = userInput.nextInt();
				
				boolean chooseCommand = false;
				while(!chooseCommand) {
					if(choice == 1) {
						Inventory command = new Inventory();
						
						boolean runProgram = false;
						while(!runProgram) {
						    boolean inputInvalid = false;
							while(!inputInvalid) {
								System.out.println("\nEnter the number of corresponding activity:");
								System.out.print("[1] Add Item \n[2] Update Item \n[3] Remove Item \n--> ");
								int type = userInput.nextInt();
								if(type == 1) {
									nac_database = command.addItem(nac_database);
										try {
											Inventory.setNAC_DB(nac_database);
										} catch (IOException e) {
											e.printStackTrace();
										}
								} else if (type == 2) {
									command.updateItem(nac_database);
										try {
											Inventory.setNAC_DB(nac_database);
										} catch (IOException e) {
											e.printStackTrace();
										}
								} else if (type == 3) {
									command.removeItem(nac_database);
										try {
											Inventory.setNAC_DB(nac_database);
										} catch (IOException e) {
											e.printStackTrace();
										}
								} else {
									System.out.println("Ooops! You've entered an invalid input.");
									System.out.println("Start again?\n\t[1] Yes\n\t[2] No");
									int doAgain = userInput.nextInt();
										if(doAgain == 1) {
											System.out.print("Beginning program");
											for(int i=0;i<7;i++) {
												System.out.print(".");
											}
											System.out.println("");
											inputInvalid = true;
										} else if(doAgain == 2) {
											System.out.println("Exit");
											 runProgram = true;
											 inputInvalid = true;
										} else {
											System.out.println("Invalid Input\n\n");
										}	
								}
							}
						}
					} else if(choice == 2) {
						System.out.print("---- Shopping Cart is under maintenance ----");
						System.out.print("\n[1] Back to Main Menu" +
										 "\n--> ");
						int shoppingCartChoice = userInput.nextInt();	
							if(shoppingCartChoice == 1) {
								chooseCommand = true;
							} else {
								System.out.print("Invalid Input!");
							}
					} else if(choice == 3) {
						System.out.print("---- Cashier is under Maintenance ----");
						System.out.print("\n[1] Back to Main Menu" +
										 "\n--> ");
						int cashierChoice = userInput.nextInt();	
							if(cashierChoice == 1) {
								chooseCommand = true;
							} else {
								System.out.print("Invalid Input!");
							}				
					} else if(choice == 4) {
						System.out.print("---- Your account just had been logout. ----");
						chooseCommand = true;
						chooseActivity = true;
						NutsAboutCandy.main(null);
					} else {
						System.out.print("Invalid input!");
					}
				}
			}
		}
}
	

