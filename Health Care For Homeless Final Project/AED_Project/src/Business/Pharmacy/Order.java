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
public class Order {
    
    private Supplier supplier;
    private String medicineName;
    private float marketPrice;
    private int quantity;
    private String status;
    private ArrayList<Drug> drugList;
    private ArrayList<OrderItem> orderItem;
    
       
    public Order() {
        drugList = new ArrayList<>();
        orderItem = new ArrayList<>();
    }

    public ArrayList<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ArrayList<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
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
    
    
}
