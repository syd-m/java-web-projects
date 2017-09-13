package com.arif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//Instead of using the bean in XML file we use Component annotation

public class Car implements Vehicle {
	
	@Autowired
	private Tyre tyre;
	
	public Tyre getTyre() {
		return tyre;
	}
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
	public void drive() {
		System.out.println("car " + tyre);
	}

}
