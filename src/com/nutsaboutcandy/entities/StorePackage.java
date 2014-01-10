package com.nutsaboutcandy.entities;

import java.io.Serializable;

public class StorePackage implements Serializable{
	
	private static final long serialVersionUID = -4810837094472076003L;
	
	private Product product;
	private String size;
	private Integer weighInGrams;
	private Integer numberOfStock;
	
	public StorePackage(Product product, String size, Integer numberOfStock) {
		setProduct(product);
		setSize(size);
		setNumberOfStock(numberOfStock);	
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
		
		if(size.equalsIgnoreCase("Small")) {
			weighInGrams = 50;
		} else if(size.equalsIgnoreCase("Medium")) {
			weighInGrams = 100;
		} else if(size.equalsIgnoreCase("Large")) {
			weighInGrams = 150;
		}	
	}
	
	public Integer getWeighInGrams() {
		return weighInGrams;
	}
	
	public void setWeighInGrams(Integer weighInGrams) {
		this.weighInGrams = weighInGrams;
	}
	
	public Integer getNumberOfStock() {
		return numberOfStock;
	}
	
	public void setNumberOfStock(Integer numberOfStock) {
		this.numberOfStock = numberOfStock;
	}
}
