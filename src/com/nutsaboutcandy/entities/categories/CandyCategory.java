package com.nutsaboutcandy.entities.categories;

import java.math.BigDecimal;

import com.nutsaboutcandy.entities.ingredients.Candy;
import com.nutsaboutcandy.entities.ingredients.Ingredient;

public class CandyCategory extends Category {
	
	public Boolean isACandy(Ingredient ingredient){
		if (ingredient instanceof Candy) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String getType() {
		return super.getType();
	}

	@Override
	public void setType(String type) {
		super.setType(type);
	}

	@Override
	public BigDecimal getMediumPrice() {
		return super.getMediumPrice();
	}

	@Override
	public BigDecimal getSmallPrice() {
		return super.getSmallPrice();
	}

	@Override
	public BigDecimal getLargePrice() {
		return super.getLargePrice();
	}
}
