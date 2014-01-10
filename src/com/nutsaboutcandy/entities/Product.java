package com.nutsaboutcandy.entities;

import java.io.Serializable;
import java.util.ArrayList;

import com.nutsaboutcandy.entities.categories.Category;
import com.nutsaboutcandy.entities.ingredients.Ingredient;


public class Product implements Serializable {
	
	private static final long serialVersionUID = -7034974955555043442L;
	
	private String name;
	private Category category;
	ArrayList<Ingredient> listOfIngredients;
	
	public Product(String name, Category category, ArrayList<Ingredient> listOfIngredients) {
		setName(name);
		setCategory(category);
		setIngredients(listOfIngredients);	
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Ingredient> getListOfIngredients() {
		return listOfIngredients;
	}
	
	public Category getCategory () {
		return category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIngredients(ArrayList<Ingredient> ingredient) {
		this.listOfIngredients = ingredient;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	

	
	
	
	
}
