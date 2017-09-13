package com.arif;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {
	public static void main(String[] args) {
		
		//we can use getBean method from two Interfaces BeanFactory (for small apps) & ApplicationContext (large ee apps, superset of BF)
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Car obj = (Car) context.getBean("car");
		obj.drive();
		
		Bike obj1 = (Bike) context.getBean("bike");
		obj1.drive();
		
//		Tyre t = (Tyre) context.getBean("tyre");
//		System.out.println(t);
	}
}
