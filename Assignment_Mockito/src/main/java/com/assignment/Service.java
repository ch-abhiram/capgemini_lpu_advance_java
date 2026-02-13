package com.assignment;

public class Service {
	
	private DiscountRepo repo;
	
	public Service(DiscountRepo repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	public double calFinalPrice(double price,String productCode) {
		double discount = repo.getDiscountPercentage(productCode);
		double finalprice = price - (price*discount/100);
		
		return finalprice;
	}

}
