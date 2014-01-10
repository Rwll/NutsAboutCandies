package com.nutsaboutcandy.entities.categories;

import java.math.BigDecimal;

import com.nutsaboutcandy.entities.ingredients.Ingredient;
import com.nutsaboutcandy.entities.ingredients.Nut;

public class NutsCategory extends Category {
	
	public Boolean isANut(Ingredient ingredient){
		if (ingredient instanceof Nut) {
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
