////////////////////////////////////////////////////////////////////
// [Matteo] [Marchiori] [1143333]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.exception.MenuItemException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for restaurant manager
 * @author matteo
 */
public class RestaurantBillTest {

    private RestaurantBill bill = new RestaurantBillImpl();

    @Test
    public void getOrderPrice_SumPricesOfMenuItems_priceSumCorrect() throws RestaurantBillException, MenuItemException {
        List<MenuItem> items = createTwoMenuItemsWithGivenPrices(5, 6);
        assertEquals(11, bill.getOrderPrice(items),0.001);
    }

    @Test
    public void getOrderPrice_SumPricesOfMenuItems_FreePizzaIfMoreThan10Pizza() throws RestaurantBillException, MenuItemException {
        List<MenuItem> items = createMenuItemsListCorrect(12, 3, 8, MenuItem.itemType.Pizza);
        double freePrice = 8;
        double price;
        for (MenuItem pizza : items) {
            price = pizza.getPrice();
            if (price < freePrice) {
                freePrice = price;
            }
        }
        assertEquals(getTotalPriceOfMenuItems(items) - freePrice, bill.getOrderPrice(items),0.001);
    }

    @Test
    public void getOrderPrice_SumPricesOfMenuItems_5PercentDiscountIfMoreThan100TotalPrice() throws RestaurantBillException, MenuItemException {
        List<MenuItem> items = createTwoMenuItemsWithGivenPrices(50, 60);
        assertEquals(getTotalPriceOfMenuItems(items) - 5.5, bill.getOrderPrice(items),0.001);
    }

    @Test(expected = RestaurantBillException.class)
    public void getOrderPrice_SumPricesOfMenuItems_ExceptionThrownIfMoreThan20MenuItems() throws RestaurantBillException, MenuItemException {
        List<MenuItem> items = createMenuItemsListCorrect(22, 3, 12, null);
        @SuppressWarnings("unused")
        double price = bill.getOrderPrice(items);
    }

    private List<MenuItem> createMenuItemsListCorrect(int numberOfItems, double minPrice, double maxPrice, MenuItem.itemType type) throws MenuItemException {
        List<MenuItem> items = new ArrayList<MenuItem>();
        Random r = new Random();
        for (int i = 0; i < numberOfItems; i++) {
            Double price = minPrice + (maxPrice - minPrice) * r.nextDouble();
            if (type == null) {
                type = generateTypeOfMenuItem();
            }
            items.add(new MenuItem(type, "", price));
        }
        return items;
    }

    private List<MenuItem> createTwoMenuItemsWithGivenPrices(double price1, double price2) throws MenuItemException {
        List<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem(MenuItem.itemType.Pizza, "Pizza di esempio", price1));
        items.add(new MenuItem(MenuItem.itemType.Primo, "Primo di esempio", price2));
        return items;
    }

    private MenuItem.itemType generateTypeOfMenuItem() {
        Random r = new Random();
        return r.nextBoolean() ? MenuItem.itemType.Pizza : MenuItem.itemType.Primo;
    }

    private double getTotalPriceOfMenuItems(List<MenuItem> items) {
        double sum = 0;
        for (MenuItem mi : items) {
            sum += mi.getPrice();
        }
        return sum;
    }
}
