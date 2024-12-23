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
public class Meal {
    String name;
    String ingredients;
    double price;
    
    public Meal(){}
    
    public Meal(String name , String ingredient , double price){
    this.name = name ;
    this.ingredients = ingredient ;
    this.price = price ;
    }
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

 public void setPrice(double price) {
        this.price = price;
    }

 //to do
    public List<Meal> read(){
    List<Meal> meals = new LinkedList<>();
        
    
    return meals;
    }
    
    public void save(Meal m){
        
    }
     
    public void delete(Meal m){
    }
    
    public void update(Meal orginalMeal ,Meal newMeal){
    }
   
}
