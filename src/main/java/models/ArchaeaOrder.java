package models;

import models.*;

public class ArchaeaOrder extends ArchaeaClass {
    public String orderName;
    public int orderId;


    public ArchaeaOrder(String domainName, String phylumName, String className, String orderName){
        super(domainName, phylumName, className);
        this.orderName = orderName;
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
