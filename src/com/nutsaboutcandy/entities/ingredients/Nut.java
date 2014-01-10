package com.nutsaboutcandy.entities.ingredients;

public class Nut extends Ingredient {

	private String name;
	
	public Nut(String name) {
		super(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	
}
