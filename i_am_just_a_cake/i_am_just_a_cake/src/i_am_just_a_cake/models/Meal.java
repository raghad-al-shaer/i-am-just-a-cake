/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.models;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List; 
import i_am_just_a_cake.logic.FileManager;
import i_am_just_a_cake.logic.Helpers;
import i_am_just_a_cake.logic.InvalidMealNameException;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Meal implements Serializable{
    private String name;
    private String ingredients;
    private double price;
    private int quantity;
    
    public Meal(){}
    
    public Meal(String name , String ingredient , double price ,int quantity){
    this.name = name ;
    this.ingredients = ingredient ;
    this.price = price ;
    this.quantity = quantity;
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
 
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity ;
    }

    public static List<Meal> readAllMeals()throws  ClassNotFoundException, IOException{
        return FileManager.readFromFile("data/meals/meals.dat");
    }
    
    public void save()throws ClassNotFoundException ,IOException, InvalidMealNameException{
         List<Meal> meals = readAllMeals();
          if(Helpers.checkMealNameIsUnique(meals ,this )){
            FileManager.writeObjToFile("data/meals/meals.dat", this);
          }else{
            throw new InvalidMealNameException();
          }
    }
     
    public void update(Meal updatedMeal)throws  ClassNotFoundException, IOException, InvalidMealNameException{//this method is to be called upon the Meal to be updated
        List<Meal> mealsToUpdate = readAllMeals();
        if(Helpers.checkMealNameIsUnique(mealsToUpdate ,updatedMeal )){
          List<Meal> updatedMeals = Helpers.updateList(mealsToUpdate , this ,updatedMeal);
          FileManager.writeListToFile("data/meals/meals.dat", updatedMeals);
        }else{
          throw new InvalidMealNameException();
        }
    }
    
    public void delete()throws  ClassNotFoundException, IOException{//this method is to be called upon the Meal to be deleted
        List<Meal> meals = readAllMeals();
        if(meals != null && !meals.isEmpty()){
            meals.removeIf(obj -> obj.equals(this));
            FileManager.writeListToFile("data/meals/meals.dat", meals);
        }
        
    }
   
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  // Same object reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  // Different class or null object
        }
        Meal otherMeal = (Meal) obj;
        return this.name.equals(otherMeal.name) &&
               this.ingredients.equals(otherMeal.ingredients) &&
               this.price == otherMeal.price &&
               this.quantity == otherMeal.quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.ingredients);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 37 * hash + this.quantity;
        return hash;
    }

    
    
}
