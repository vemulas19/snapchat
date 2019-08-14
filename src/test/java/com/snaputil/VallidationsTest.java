package com.snaputil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class VallidationsTest {
	
	// @BeforeClass, @AfterClass, @Before, @After
	@BeforeClass
	public static void loadProperties(){
		System.out.println("Properties, connections, all the data has been loaded...");
	}
	
	@AfterClass
	public static void closeProperties(){
		System.out.println("Properties, connections, all the data has been closed...");
	}
	@Before
	public void testMethodData(){
		System.out.println("This will call before every test method...");
	}
	
	@After
	public void testMethodCloseData(){
		System.out.println("This will call after every test method...");
	}
	
	
	@Test
	public void testIsValid(){
		System.out.println("Test case1");
		Validations val= new Validations();
		
		Assert.assertTrue("this is for valid mail", val.isValidMail("gajjellis@gmail.com"));
		
		Assert.assertFalse(val.isValidMail("gajjellisgmail.com"));
		
		Assert.assertFalse(val.isValidMail("gajjellis@gmailcom"));
		Assert.assertFalse(val.isValidMail("22gajjellis@gmail.com"));
		Assert.assertFalse(val.isValidMail("gajjellis@gmail.com222"));
		//Assert.assertTrue(val.isValid("9966678280")); //pass
		//Assert.assertTrue(val.isValid("996667828"));
		
	}
	
	@Test
	public void testAddition(){
		System.out.println("Test case2");
		
		Validations val= new Validations();
		
		Assert.assertEquals(100, val.addition(50, 50));
		
		Assert.assertNotEquals(120, val.addition(50, 50));
		
	//	Assert.assertTrue(val.isValid("9966678280")); //pass
		//Assert.assertTrue(val.isValid("996667828"));
		
	}

}
