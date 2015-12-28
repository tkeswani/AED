/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy;

import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class OrderCatalog {
 
    private ArrayList<Order> orderList;

    public OrderCatalog() {
        orderList = new ArrayList<>();
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    public Order addOrder() {
        Order order = new Order();
        return order;
    }
}
