/*
 * @(#)ComponentTest.java	0.0.1-SNAPSHOT
 *
 * Copyright 2009 Telefónica I+D.
 */
package com.softwaresano.examples.calculator.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 * This class test the test-calculator interface
 * @version    0.0.1-SNAPSHOT
 * @author     ${developer.name}
 */

final public class Component {
	private com.softwaresano.examples.calculator.Calculator component = null;
	/**
	* This method initializes the component. It assign the implementation component 
	* If the implementation component doesn't exist. It must be create a Mock Object  
	*/
	@Before
	public void testStart() {
	    	//If the implementation doesn't exist. We will use a mock object
	        //component = (com.softwaresano.examples.calculator.test-calculator.Component)com.softwaresano.examples.calculator.test-calculator.test.mock.Component.getInstance();
	        // else
	        component = new com.softwaresano.examples.calculator.impl.Calculator();
	}
	
	/**
	 * This method get the necessary resources
	 */
	@BeforeClass
	public static void BeforeClass() {
		// Para este ejemplo no hacemos nada, pero exponemos el método por
		// motivos didácticos exclusivamente
	}
	
	/**
	 * This method return the resources used by @BeforeClass method
	 */
	@AfterClass
	public static void afterClass() {
		// Para este ejemplo no hacemos nada, pero exponemos el método por
		// motivos didácticos exclusivamente
	}

	/**
	 * This method is runned in each test AFTER to invoke each test
	 */
	@After
	public void testEnd() {
		// Para este ejemplo no hacemos nada, pero exponemos el método por
		// motivos didacticos exclusivamente
	}
	/**
	 * Test the <code>add</code> operation
	 */
	@Test
	public void testAdd() {
		assertEquals(4, component.add(2,2));
	}

        /**
	 * Test the <code>add</code> operation
	 */
	@Test
	public void testStringAdd() {
		assertEquals("3 + 2 = 5", component.add("3","2"));
	}

	/**
	 * Test the <code>add</code> operation with null arguments
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testStringAddWithNullOperand() {
		component.add("3",null);
	}

	/**
	 * Test the <code>add</code> operation with empty arguments
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testStringAddWithEmptyOperand() {
		component.add("",null);
	}

	/**
	 * Test the <code>add</code> operation with illegal Operand
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testStringAddWithIllegalOperand() {
		component.add("4","-a");
	}

	
	/**
	 * Test the <code>add</code> operation with a negative operand
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddNegativeFirstOperand() {
		component.add(-1,2);
	}
	
	/**
	 * Test the <code>add</code> operation with a negative operand
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddNegativeSecondOperand() {
		component.add(1,-2);
	}
	
	/**
	 * Test the <code>add</code> operation with a negative operand
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddNegativeFirstAndSecondOperand() {
		component.add(-1,-2);
	}
	
	/**
	 * Test the <code>add</code> operation with a negative operand
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeAdd() {
		component.add(-1,2);
	}

        /**
	 * Test the <code>add</code> operation with a two biggers operands
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testOverflowAdd() {
		component.add(3000,9000);
	}
}
