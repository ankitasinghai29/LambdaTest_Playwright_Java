package Testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class GrandParent {
	
	public int a=0;
	
	@BeforeTest
	public void m1()
	{
		a=10;
		System.out.println("Before Test: "+a);
	}
	
	@AfterTest
	public void m2()
	{
		a=10;
		System.out.println("After Test: "+a);
	}
	
	@BeforeClass
	public void m3()
	{
		a=20;
		System.out.println("Before Class: "+a);
	}
	
	@AfterClass
	public void m4()
	{
		a=20;
		System.out.println("After Class: "+a);
	}
	
	@BeforeMethod
	public void m5()
	{
		a=30;
		System.out.println("Before Method: "+a);
	}
	
	@AfterMethod
	public void m6()
	{
		a=30;
		System.out.println("After Method: "+a);
	}
}
