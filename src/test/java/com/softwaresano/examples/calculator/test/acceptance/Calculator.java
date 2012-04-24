package com.softwaresano.examples.calculator.test.acceptance;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;


@RunWith(ConcordionRunner.class)
public class Calculator {
    
    public String add(String a, String b) {
    	final com.softwaresano.examples.calculator.Calculator component = new com.softwaresano.examples.calculator.impl.Calculator();
    	try{
    		return component.add(a, b);
    	} catch (IllegalArgumentException illegalException){
    		return illegalException.getMessage();
    	}
    }
}
