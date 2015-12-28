/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Pharmacy.Order;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class MasterOrderCatalog {
    private ArrayList<Order> orderList;
    
    
    public MasterOrderCatalog() {
        orderList = new ArrayList<>();
    }

    
    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    
}
