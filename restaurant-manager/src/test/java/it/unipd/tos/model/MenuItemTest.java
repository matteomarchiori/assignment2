////////////////////////////////////////////////////////////////////
// [Matteo] [Marchiori] [1143333]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.exception.MenuItemException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for menu item
 * @author matteo
 */
public class MenuItemTest {
    @Test(expected = MenuItemException.class)
    public void constructor_checkPrice_ExceptionThrownIfPriceLowerThan0() throws MenuItemException {
        @SuppressWarnings("unused")
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",-5);
    }
    
    @Test
    public void getType_getTypeOfMenuItem_typeEqualsTypeGiven() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        assertEquals(item.getType(),MenuItem.itemType.Pizza);
    }
    
    @Test
    public void getName_getNameOfMenuItem_nameEqualsNameGiven() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        assertEquals(item.getName(),"Margherita");
    }
    
    @Test
    public void getPrice_getPriceOfMenuItem_priceEqualsPriceGiven() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        assertEquals(item.getPrice(),5,0.001);
    }
    
    @Test
    public void setType_setTypeOfMenuItem_typeEqualsTypeGivenAfterSet() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        item.setType(MenuItem.itemType.Primo);
        assertEquals(item.getType(),MenuItem.itemType.Primo);
    }
    
    @Test
    public void setName_setNameOfMenuItem_nameEqualsNameGivenAfterSet() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        item.setName("Diavola");
        assertEquals(item.getName(),"Diavola");
    }
    
    @Test
    public void setPrice_setPriceOfMenuItem_priceEqualsPriceGivenAfterSet() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        item.setPrice(6);
        assertEquals(item.getPrice(),6,0.001);
    }
    
    @Test(expected = MenuItemException.class)
    public void setPrice_setPriceOfMenuItem_exceptionThrownIfPriceLowerThan0() throws MenuItemException {
        MenuItem item = new MenuItem(MenuItem.itemType.Pizza,"Margherita",5);
        item.setPrice(-6);
    }
}
