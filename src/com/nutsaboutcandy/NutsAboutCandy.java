package com.nutsaboutcandy;

import java.io.IOException;
import java.util.ArrayList;

import com.nutsaboutcandy.entities.StorePackage;
import com.nutsaboutcandy.features.*;

/**
 * @author Rowell Canlapan
 * @since August 5, 2013
 * @version 1.0
 * 
 * This application implements the inventory feature of Nuts About Candy.
 */

public class NutsAboutCandy {
		
	public static void main(String[] args) {
		
		ArrayList<StorePackage> nac_database = null;
		try {
			nac_database = Inventory.getNAC_DB();
		} catch (ClassNotFoundException | IOException e) {
			nac_database = new ArrayList<StorePackage>();
		} 
		
		Login login = new Login();
		
		login.doLogin();
		login.doStartMenu(nac_database);
		
	
	}
}
