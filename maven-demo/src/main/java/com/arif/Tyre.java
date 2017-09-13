package com.arif;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
	public String brand;
	
	//constructor injection defined in XML using constructor arg tag  
//	public Tyre(String brand) {
//		super();
//		this.brand = brand;
//	}

	public String getBrand() {
		return brand;
	}
	
	//setter injection defined in XML using property tag  
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "It's working";
	}
}
