/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import i_am_just_a_cake.logic.FileManager;
import i_am_just_a_cake.logic.Helpers;
import java.util.Objects;
/**
 *
 * @author ASUS
 */
public class Order implements Serializable{

    private User client;
    private List<OrderMeal> meals;
    private OrderType orderType;
    private PaymentMethod paymentMethod;
    private double tip;
    private OrderState orderState;
    private LocalDateTime dateTime;
    
    public Order() {
    }

    public Order(User client, List<OrderMeal> meals, OrderType orderType, PaymentMethod paymentMethod, double tip, OrderState orderState , LocalDateTime dateTime) {
        this.client = client;
        this.meals = meals;
        this.orderType = orderType;
        this.paymentMethod = paymentMethod;
        this.tip = tip;
        this.orderState = orderState;
        this.dateTime = dateTime;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public List<OrderMeal> getMeals() {
        return meals;
    }

    public void setMeals(List<OrderMeal> meals) {
        this.meals = meals;
    }

    public OrderType getOrderType() {
        return orderType;
    }
   
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

      public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    
      public double calculateTotalPrice() {
        double total = 0.0;

        for (OrderMeal meal : meals) {
            total += meal.getMeal().getPrice() * meal.getQuantity(); 
        }

        total += tip;

        return total;
    }
    
    
    public static List<Order> readAllOrders()throws  ClassNotFoundException, IOException{
        return FileManager.readFromFile("data/orders/orders.dat");
    }
    
    public void save()throws ClassNotFoundException ,IOException{
        FileManager.writeObjToFile("data/orders/orders.dat", this);
    }
    
    public void update(Order UpdatedOrder)throws  ClassNotFoundException, IOException{//this method is to be called upon the order to be updated
        List<Order> ordersToUpdate = readAllOrders();
        List<Order> updatedOrders = Helpers.updateList(ordersToUpdate , this ,UpdatedOrder);
        FileManager.writeListToFile("data/meals/meals.dat", updatedOrders);
        
    }
    
    public void delete()throws  ClassNotFoundException, IOException{//this method is to be called upon the Meal to be deleted
        List<Order> orders = readAllOrders();
        if(orders != null && !orders.isEmpty()){
        orders.removeIf(obj -> obj.equals(this));
        FileManager.writeListToFile("data/meals/meals.dat", orders);
        }
    }
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Order otherOrder = (Order) obj;

        return this.client.equals(otherOrder.client) &&
               this.meals.equals(otherOrder.meals) &&
               this.orderType == otherOrder.orderType &&  
               this.paymentMethod == otherOrder.paymentMethod &&  
               Double.compare(this.tip, otherOrder.tip) == 0 &&  
               this.orderState == otherOrder.orderState &&  
               this.dateTime.equals(otherOrder.dateTime);  
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.client);
        hash = 41 * hash + Objects.hashCode(this.meals);
        hash = 41 * hash + Objects.hashCode(this.orderType);
        hash = 41 * hash + Objects.hashCode(this.paymentMethod);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.tip) ^ (Double.doubleToLongBits(this.tip) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.orderState);
        hash = 41 * hash + Objects.hashCode(this.dateTime);
        return hash;
    }

  

}


