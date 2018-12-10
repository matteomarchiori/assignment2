/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unipd.tos.model.exception;

import org.junit.Test;

/**
 * Tests for exception
 * @author matteo
 */
public class MenuItemExceptionTest {
    @Test(expected = MenuItemException.class)
    public void constructor_emptyConstructor_ExceptionThrownWithEmptyConstructor() throws MenuItemException {
        throw new MenuItemException();
    }
    
    @Test(expected = MenuItemException.class)
    public void constructor_messageConstructor_ExceptionThrownWithMessageConstructor() throws MenuItemException {
        throw new MenuItemException("Thrown new exception");
    }
}
