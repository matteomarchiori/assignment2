/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipd.tos.business.exception;

import org.junit.Test;

/**
 * Tests for exception
 * @author matteo
 */
public class RestaurantBillExceptionTest {
    @Test(expected = RestaurantBillException.class)
    public void constructor_emptyConstructor_ExceptionThrownWithEmptyConstructor() throws RestaurantBillException {
        throw new RestaurantBillException();
    }
    
    @Test(expected = RestaurantBillException.class)
    public void constructor_messageConstructor_ExceptionThrownWithMessageConstructor() throws RestaurantBillException {
        throw new RestaurantBillException("Thrown new exception");
    }
}
