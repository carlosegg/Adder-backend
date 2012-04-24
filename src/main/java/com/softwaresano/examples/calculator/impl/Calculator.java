/**
 * @(#)Component.java 0.0.1-SNAPSHOT
 *
 * Copyright 2009 Telefónica I+D.
 */
package com.softwaresano.examples.calculator.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static java.text.MessageFormat.format;

/**
 * <p>This class implements a Component Interface. In this case this
 * component  is a simple Calculator.</p>
 *
 * <p>Sample:</p>
 * <PRE>
 *    Component component = new com.softwaresano.examples.calculator.Component();
 *    System.out.println(component.add(5.0,3.0));
 * </PRE>
 *
 * @version    0.0.1-SNAPSHOT
 * @author     ${developerName}
 */
public final class Calculator implements com.softwaresano.examples.calculator.Calculator {

    /**
     *  The logger. A new logger <code>com.softwaresano.examples.calculator.Component</code> is
     *  created to add the logs of this Component
     */
    private static final  Log LOG = LogFactory.getLog(Calculator.class);

    /**
     * This method calculates the added of two numbers.
     * @param a first operand
     * @param b second operand
     * @return The added of  <TT>a</TT> and <TT>b</TT>
     */
    @Override
    public int add(final int a, final int b){
    	if ( (a<MIN_VALUE) || (b<MIN_VALUE) || (a>MAX_VALUE) || (b>MAX_VALUE)){
    		throw new IllegalArgumentException(ERROR_PARAMETERS);
    	}
        if (LOG.isDebugEnabled()) {
            LOG.debug(format("Calculando la suma de [{0}] y [{1}]",
                             new Object[]{a, b}));
        }
        final int result = a + b;
        if ( result > MAX_VALUE){
            throw new IllegalArgumentException(ERROR_OVERFLOW);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(format("Resultado = {0}", new Object[]{result}));
        }
        return result;
    }

     /**
     * This method calculates the added of two numbers.
     * @param a first operand
     * @param b second operand
     * @return The added of  <TT>a</TT> and <TT>b</TT>
     */
    @Override
    public String add(final String a, final String b) {
        int sum1 = 0 ,sum2 = 0;
        if  (( a == null ) || (b==null)){
            throw new IllegalArgumentException(ERROR_PARAMETERS);
        }
        try{
            sum1 = Integer.valueOf(a);
            sum2 = Integer.valueOf(b);
        } catch (NumberFormatException nfException){
            throw new IllegalArgumentException(ERROR_PARAMETERS,nfException);
        }
        return String.format("%s + %s = %s",a,b,add(sum1,sum2));
    }
}
