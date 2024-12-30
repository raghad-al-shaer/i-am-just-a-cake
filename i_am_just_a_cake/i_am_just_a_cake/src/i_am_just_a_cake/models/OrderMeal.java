/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class OrderMeal implements Serializable {
    private Meal meal;
    private int quantity;

    /**
     * @return the meal
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * @param meal the meal to set
     */
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
        @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OrderMeal otherOrderMeal = (OrderMeal) obj;

        return this.meal.equals(otherOrderMeal.meal) && this.quantity == otherOrderMeal.quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.meal);
        hash = 67 * hash + this.quantity;
        return hash;
    }
}
