/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.models;

import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Order {
    String clientName;
    List<Meal> meals;
    OrderType orderType;
    PaymentMethod paymentMethod;
    double tip;
    OrderState orderState;
    
    public Order() {
    }

    public Order(String clientName, List<Meal> meals, OrderType orderType, PaymentMethod paymentMethod, double tip, OrderState orderState) {
        this.clientName = clientName;
        this.meals = meals;
        this.orderType = orderType;
        this.paymentMethod = paymentMethod;
        this.tip = tip;
        this.orderState = orderState;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
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
    
    //to do
    public List<Order> Read(){
        List<Order> orders = new LinkedList<>();
        
        return orders;
    }
    
    public void save(Order m){
    }
     
    public void delete(Order m){
    }
    
    public void update(Order order , OrderState newOrderState){
    }
    
}


