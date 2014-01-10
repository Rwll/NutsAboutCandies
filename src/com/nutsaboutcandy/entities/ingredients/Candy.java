package com.nutsaboutcandy.entities.ingredients;

public class Candy extends Ingredient {

	private String name;
	
	public Candy(String name) {
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
