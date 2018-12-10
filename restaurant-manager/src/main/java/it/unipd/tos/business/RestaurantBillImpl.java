////////////////////////////////////////////////////////////////////
// [Matteo] [Marchiori] [1143333]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;

/**
 * Implementation of restaurant manager
 * @author matteo
 */
public class RestaurantBillImpl implements RestaurantBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        if(itemsOrdered.size()>20)throw new RestaurantBillException("Troppi elementi aggiunti al conto.");
        double total = 0;
        int countPizza = 0;
        double freePizzaPrice = Double.MAX_VALUE;
        for(MenuItem mi : itemsOrdered){
            total += mi.getPrice();
            if(mi.getType().equals(MenuItem.itemType.Pizza)){
                countPizza++;
                if(mi.getPrice()<freePizzaPrice)freePizzaPrice = mi.getPrice();
            }
        }
        if(countPizza>10) total -= freePizzaPrice;
        if(total>100)total*=0.95;
        return total;
    }
}
