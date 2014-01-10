package com.nutsaboutcandy.entities.ingredients;

import java.io.Serializable;

public abstract class Ingredient implements Serializable {
	
	private static final long serialVersionUID = 1071754454677863290L;
	
	private String name;

	public Ingredient(String name){
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
