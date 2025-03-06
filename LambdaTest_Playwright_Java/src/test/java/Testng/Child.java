package Testng;

import org.testng.annotations.Test;

public class Child extends Parent{
	
	@Test (priority = 2)
	public void helloChild()
	{
		System.out.println("hello child: "+a);
	}

}
