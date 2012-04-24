/*
 * @(#)Component.java	0.0.1-SNAPSHOT
 *
 * Copyright 2009 Telefónica I+D.
 */
package com.softwaresano.examples.calculator.test.mock;

import org.jmock.Expectations;
import org.jmock.Mockery;

/**
 * <p>This class is a Mock implementation of the Component Interface. In this case this component  is
 * a simple Calculator.</p>
 *  
 * <p>Sample:</p>
 * <PRE>
 *    Component component = component = (com.softwaresano.examples.calculator.Component)com.softwaresano.examples.calculator.test.mock.Component.getInstance();
 *    System.out.println(component.add(2.0,2.0));
 * </PRE>
 *
 * @version    0.0.1-SNAPSHOT
 * @author     ${developerName}
 */
final public class Component {

    public static Object getInstance() {
        Mockery context = new Mockery();
        final com.softwaresano.examples.calculator.Calculator component = context.mock(com.softwaresano.examples.calculator.Calculator.class);
        // expectations
        context.checking(new Expectations() {
            {
                //Cuando se invoque el método add con los valores 2 y 2
                allowing(component).add(2, 2);
                //la suma es:4
                will(returnValue(4));
                allowing(component).add("3","2");
                will(returnValue("3 + 2 = 5"));
                allowing(component).add(-1, 2);
                will(throwException(new IllegalArgumentException("a y b no pueden ser números negativos")));
                allowing(component).add(1, -2);
                will(throwException(new IllegalArgumentException("a y b no pueden ser números negativos")));
                allowing(component).add(-1, -2);
                will(throwException(new IllegalArgumentException("a y b no pueden ser números negativos")));
                allowing(component).add(3000,9000);
                will(throwException(new IllegalArgumentException("a y b no pueden ser números negativos")));
            }
        });
        return component;
    }
}

