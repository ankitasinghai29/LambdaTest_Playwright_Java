package Testng;

import org.testng.annotations.Test;

public class Parent extends GrandParent{
	
	@Test(priority = 1)
	public void helloParent()
	{
		System.out.println("hello Parent"+a);
	}

}
