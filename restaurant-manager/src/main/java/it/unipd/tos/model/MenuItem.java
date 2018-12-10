////////////////////////////////////////////////////////////////////
// [Matteo] [Marchiori] [1143333]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.exception.MenuItemException;

/**
 * Class which represent a menu item
 * @author matteo
 */
public class MenuItem {

    public enum itemType {
        Pizza, Primo
    };
    private itemType type;
    private String name;
    private double price;

    public MenuItem(itemType type, String name, double price) throws MenuItemException {
        if(price<0)throw new MenuItemException("Item not valid");
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public itemType getType() {
        return type;
    }

    public void setType(itemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws MenuItemException {
        if(price<0)throw new MenuItemException("Item not valid");
        this.price = price;
    }

}
