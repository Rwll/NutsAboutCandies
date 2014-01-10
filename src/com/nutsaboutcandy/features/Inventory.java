package com.nutsaboutcandy.features;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.nutsaboutcandy.entities.*;
import com.nutsaboutcandy.entities.categories.*;
import com.nutsaboutcandy.entities.ingredients.*;


	public class Inventory {

		private static Scanner userInput = new Scanner(System.in);
		
		//Exception
		public static ArrayList<StorePackage> getNAC_DB() throws IOException, ClassNotFoundException {
		
			FileInputStream inputDetail = new FileInputStream("nac_dbase.log");
			ObjectInputStream objectInput = new ObjectInputStream(inputDetail);

			@SuppressWarnings("unchecked")
			ArrayList<StorePackage> nac_database = (ArrayList<StorePackage>) objectInput.readObject();
			objectInput.close();
			return nac_database;
			
		}
		
		public static void setNAC_DB(ArrayList<StorePackage> nac_database) throws IOException {
			 FileOutputStream fos = new FileOutputStream("nac_dbase.log");
		      ObjectOutputStream oos = new ObjectOutputStream(fos);

		      oos.writeObject(nac_database);

		      oos.close();
		}
		
		// BEGINNING OF ADD ITEM METHOD
		public static ArrayList<StorePackage> addItem(ArrayList<StorePackage> nac_database2) {
			
				ArrayList<StorePackage> nac_database = nac_database2;
				ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
				Product product = null;
				
				String productName = null;
				
				StorePackage pkgSmall = null;
				StorePackage pkgMedium = null;
				StorePackage pkgLarge = null;
				
				Integer numberOfStocksSmall = 0;
				Integer numberOfStocksMedium = 0;
				Integer numberOfStocksLarge = 0;
				
				//the user will input the category of the product.
				Category prodCategory = chooseProductCategory();
				
				//the user will input the name of the product.
				productName=enterProductName();
				
				//the user will input the product ingredients
				listOfIngredients = enterProductIngredients(prodCategory);
				
				//the user will input the type of the product which is regular or premium.
				prodCategory = enterProductType(prodCategory);
				 
				//the user will input the number of stocks of the product
				numberOfStocksSmall = enterNumberOfStocksSmall();
				numberOfStocksMedium = enterNumberOfStocksMedium();
				numberOfStocksLarge = enterNumberOfStocksLarge();
				
				System.out.println("Product Added Successfully!");
				 
				product = new Product(productName, prodCategory, listOfIngredients);
				pkgSmall = new StorePackage(product, "Small", numberOfStocksSmall);
				pkgMedium = new StorePackage(product, "Medium", numberOfStocksMedium);
				pkgLarge = new StorePackage(product, "Large", numberOfStocksLarge);
				
				nac_database.add(pkgSmall);
				nac_database.add(pkgMedium);
				nac_database.add(pkgLarge);
				return nac_database;		
		}
		
		static Category chooseProductCategory() {
			Category prodCategory = null;
			boolean confirmCategory = false;
			while(!confirmCategory) {
			System.out.print("\nEnter product category:" +
							 "\n[1] Nuts" +
							 "\n[2] Candies" + 
							 "\n[3] Mixed(Nuts & Candies)" +
							 "\n--> ");
			String productCategory  = userInput.nextLine().trim();
			
				if(productCategory.equals("1")) {
					prodCategory = new NutsCategory();
					confirmCategory = true;
				} else if(productCategory.equals("2")) {
					prodCategory = new CandyCategory();
					confirmCategory = true;
				} else if(productCategory.equals("3")) {
					prodCategory = new NutsCandyCategory();
					confirmCategory = true;
				} else {
					System.out.println("Invalid input. Try Again\n\n");
				}
			}
			return prodCategory;
		}
		
		static String enterProductName() {
			String productName="";
			boolean confirmName = false;
			while(!confirmName) {
			System.out.print("\nEnter product name: " +
							 "\n--> ");
			productName  = userInput.nextLine().trim();
			
			System.out.print("DO YOU WANT THIS TO BE YOUR PRODUCT NAME?" +
							 "\n[Y] - Yes / [N] - No" +
							 "\n--> ");
			String choice = userInput.nextLine().trim();
			
				if(choice.equalsIgnoreCase("Y")) {
					confirmName = true;
				} else if(choice.equalsIgnoreCase("N")) {
					System.out.print("Enter new name...");
				} else {
					System.out.print("Invalid input. Try Again.\n\n");
				}	
			}
			return productName;
		}
		
		static ArrayList<Ingredient> enterProductIngredients(Category prodCategory) {
			ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
			boolean listIngredients = false;
			while(!listIngredients) {
				System.out.print("\nEnter an ingredient of the product:" +
								 "\n--> ");
				String ingredientName = userInput.nextLine().trim();
				Ingredient ingredient = null;
				
				if(prodCategory instanceof NutsCategory) {
					ingredient = new Nut(ingredientName);
				} else if(prodCategory instanceof CandyCategory) {
					ingredient = new Candy(ingredientName);
				} else if(prodCategory instanceof NutsCandyCategory) {
					boolean specifyIngredient = false;
					while(!specifyIngredient) {
					System.out.print("Is it a Nut or a Candy?" +
									 "\n[1] Nut" +
									 "\n[2] Candy" +
									 "\n--> ");
					String choice = userInput.nextLine().trim();
						if(choice.equals("1")) {
							 ingredient = new Nut(ingredientName);
							specifyIngredient = true;
						} else if(choice.equals("2")) {
							ingredient = new Candy(ingredientName);
							specifyIngredient = true;
						} else {
							System.out.print("Invalid input!");
						}
					}		
				}
				listOfIngredients.add(ingredient);
				
				boolean confirmListIngredients = false;
				while(!confirmListIngredients) {
					System.out.print("Do you want to add an ingredient?" +
								 "\n[Y] - Yes / [N] - No" +
								 "\n--> ");
					String choice = userInput.nextLine().trim();	
					if(choice.equalsIgnoreCase("Y")) {
						confirmListIngredients = true;
					} else if(choice.equalsIgnoreCase("N")) {
						confirmListIngredients = true;
						listIngredients = true;
					} else {
						System.out.print("Invalid input. Try Again.\n\n");
					}			
				}
			}
			return listOfIngredients;
		}
		
		static Category enterProductType(Category category) {
			Category prodCategory = category;
			System.out.print("\nEnter the product type:" +
					 		 "\n[1] Regular" +
					 		 "\n[2] Premium" +
					 		 "\n--> ");
			 String type = userInput.nextLine().trim();
				 if(type.equals("1")) {
					 prodCategory.setType("Regular");
				 } else if(type.equals("2")) {
					 prodCategory.setType("Premium");
				 } else {
					 System.out.print("Invalid input. Try again.\n\n");
				 }
			return prodCategory;
		}

		static int enterNumberOfStocksSmall() {
			int numberOfStocksSmall=0;
			System.out.print("\nEnter the number of stocks for SMALL:" +
			    	 		 "\n--> ");
			numberOfStocksSmall = Integer.parseInt(userInput.nextLine().trim());	
			return numberOfStocksSmall;
		}
		
		static int enterNumberOfStocksMedium() {
			int numberOfStocksMedium = 0;
			System.out.print("\nEnter the number of stocks for MEDIUM:" +
	    	 		 "\n--> ");
			numberOfStocksMedium = Integer.parseInt(userInput.nextLine().trim());
			return numberOfStocksMedium;
		}
		
		static int enterNumberOfStocksLarge() {
			int numberOfStocksLarge = 0;
			System.out.print("\nEnter the number of stocks for LARGE:" +
	    	 		 "\n--> ");
			numberOfStocksLarge = Integer.parseInt(userInput.nextLine().trim());
			return numberOfStocksLarge;
		}
		// END OF ADD ITEM METHOD
		
		
		// BEGINNING OF UPDATE ITEM METHOD
		public void updateItem(ArrayList<StorePackage> nac_database) {
			
			int pkgNum = 1;
			
			System.out.println("Displaying packages...\n");
				for(StorePackage pack:nac_database) {
					System.out.print("\n\n-------------------------------------------");
					System.out.print("\nPackage # \t\t: "+ pkgNum +
							 		 "\nProduct Name \t\t: " + pack.getProduct().getName());
					System.out.print("\n-------------------------------------------");
					Category categ = pack.getProduct().getCategory();
						if(categ instanceof NutsCategory){
							System.out.println("\nCategory \t\t: Nuts");
						}else if(categ instanceof CandyCategory){
							System.out.println("\nCategory \t\t: Candies");
						} else if(categ instanceof NutsCandyCategory){
							System.out.println("\nCategory \t\t: Nuts and Candies");
						}
					System.out.print("Size \t\t\t: " + pack.getSize());
					System.out.print("\nWeigh in Grams \t\t: " + pack.getWeighInGrams());
					System.out.print("\nNumber of Stock/s \t: " +pack.getNumberOfStock());
					System.out.print("\nType \t\t\t: " + pack.getProduct().getCategory().getType());
					String sizePrice = pack.getSize();
						if(sizePrice.equalsIgnoreCase("Small")) {
							System.out.print("\nPrice \t\t\t: " + pack.getProduct().getCategory().getSmallPrice());
						} else if(sizePrice.equalsIgnoreCase("Medium")) {
							System.out.print("\nPrice \t\t\t: " + pack.getProduct().getCategory().getMediumPrice());
						} else if(sizePrice.equalsIgnoreCase("Large")) {
							System.out.print("\nPrice \t\t\t: " + pack.getProduct().getCategory().getLargePrice());
						}
					
				System.out.print("\nIngredients : ");
				for(Ingredient i : pack.getProduct().getListOfIngredients()) {
					System.out.print( "\n" + i.getName());	
					if(i instanceof Nut) {
						System.out.print(" - Nut");
					} else if(i instanceof Candy) {
						System.out.print(" - Candy");
					}
				}
				System.out.print("\n-------------------------------------------");
				pkgNum++;
			}
			
			System.out.print("\nChoose package number you want to UPDATE: " +
							 "\n--> ");
			int pkgChoiceUpdate = Integer.parseInt(userInput.nextLine().trim());
	
			System.out.print("\nEnter NEW number of stock/s: " + 
							 "\n--> ");
			int newStock = Integer.parseInt(userInput.nextLine().trim());
			
			boolean updatePackage = false;
			while(!updatePackage) {
				System.out.print("\nAre you sure you want to UPDATE the stock/s of this package?" + 
								 "\n[Y] - Yes / [N] - No " + 
								 "\n--> ");
				String yesOrNo = userInput.nextLine().trim();
					
					if(yesOrNo.equalsIgnoreCase("Y")) {
						int index = 0;	
						for(StorePackage pack:nac_database){
							if(index++==pkgChoiceUpdate-1) {
								pack.setNumberOfStock(newStock);
							}
		     					updatePackage = true;
							}
							System.out.println("Package stocks updated!");
						} else if(yesOrNo.equalsIgnoreCase("N")) {
							updatePackage = true;
						} else {
							System.out.println("Invalid input!");
						}
				}
			}
		// END OF UPDATE ITEM
	
		// BEGINNING OF REMOVE ITEM METHOD
		public void removeItem(ArrayList<StorePackage> nac_database) {
			int pkgNum = 1;	
			
				System.out.println("Displaying packages...\n");
				for(StorePackage pack:nac_database){
					System.out.print("\nPackage # \t\t: "+ pkgNum++ +
					 		 "\nProduct Name \t\t: " + pack.getProduct().getName());
					System.out.print("\n-------------------------------------------");
					Category categ = pack.getProduct().getCategory();
						if(categ instanceof NutsCategory){
							System.out.println("\nCategory \t\t: Nuts");
						}else if(categ instanceof CandyCategory){
							System.out.println("\nCategory \t\t: Candies");
						} else if(categ instanceof NutsCandyCategory){
							System.out.println("\nCategory \t\t: Nuts and Candies");
						}
						
					System.out.print("Size \t\t\t: " + pack.getSize());
					System.out.print("\nWeigh in Grams \t\t: " + pack.getWeighInGrams());
					System.out.print("\nNumber of Stock/s \t: " +pack.getNumberOfStock());
					System.out.print("\nType \t\t\t: " + pack.getProduct().getCategory().getType());
					String sizePrice = pack.getSize();
						if(sizePrice.equalsIgnoreCase("Small")) {
							System.out.print("\nPrice \t\t\t: " + pack.getProduct().getCategory().getSmallPrice());
						} else if(sizePrice.equalsIgnoreCase("Medium")) {
							System.out.print("\nPrice \t\t\t: " + pack.getProduct().getCategory().getMediumPrice());
						} else if(sizePrice.equalsIgnoreCase("Large")) {
							System.out.print("\nPrice \t\t\t: " + pack.getProduct().getCategory().getLargePrice());
						}
						
					System.out.print("\nIngredients : ");
					for(Ingredient i : pack.getProduct().getListOfIngredients()) {
						System.out.println(i.getName());	
							if(i instanceof Nut) {
								System.out.print("- Nut");
							} else if(i instanceof Candy) {
								System.out.print("- Candy");
							}
					}
					System.out.print("\n-------------------------------------------");
			 }	
				System.out.print("\nChoose package number you want to REMOVE: " + 
								 "\n--> ");
				int pkgNumRemove = Integer.parseInt(userInput.nextLine().trim());
				
				System.out.print("Are you sure you want to REMOVE the stock/s of this package?" + 
								 "\n[Y] - Yes / [N] - No " + 
								 "\n--> ");
				String yesOrNo = userInput.nextLine().trim();
				
					if(yesOrNo.equalsIgnoreCase("Y")) {
						nac_database.remove(pkgNumRemove-1);
						System.out.println("Package remove!");
					} else if(yesOrNo.equalsIgnoreCase("N")) {
						System.out.println("No package has been remove.");
					} else {
						System.out.println("Invalid input!");
					}				
		}
		// END OF REMOVE ITEM METHOD
		
}
