////////////////////////////////////////////////////////////////////
// [Matteo] [Marchiori] [1143333]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

/**
 * Generic exception for the restaurant manager
 * @author matteo
 */
public class RestaurantBillException extends Throwable{

    public RestaurantBillException() {}
    
    public RestaurantBillException(String message) {
        super(message);
    }
    
}
