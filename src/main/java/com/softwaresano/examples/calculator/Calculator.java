/**
 * @(#)Component.java  0.0.1-SNAPSHOT
 *
 * Copyright 2009 Telefónica I+D.
 */
package com.softwaresano.examples.calculator;

/**
 * <p>This Component interface represents a Calculator.</p>
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
public interface Calculator {
    /*
     *  Error parameter message
     */
     String ERROR_PARAMETERS="ERROR: Los dos sumandos han de ser números naturales de hasta 4 cifras";
     String ERROR_OVERFLOW="ERROR: OVERFLOW";
     int MIN_VALUE=0;
     int MAX_VALUE=9999;
    /**
     * This method calculates the added of two natural numbers
     * until four digits
     * @param a first operand
     * @param b second operand
     * @return The added of  <TT>a</TT> and <TT>b</TT>
     */
     int add(int a, int b);
      /**
     * This method calculates the added of two natural numbers
     * until four digits
     * @param a first operand
     * @param b second operand
     * @return The added of  <TT>a</TT> and <TT>b</TT>
     */
     String add(String a, String b);
}

