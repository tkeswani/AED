/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy;

/**
 *
 * @author Tarun
 */
public class Drug {
    
    private String name;
    private float marketPrice;
    private int quantity;
    private OrderCatalog orderCatalog;

    public Drug() {
        orderCatalog = new OrderCatalog();
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
