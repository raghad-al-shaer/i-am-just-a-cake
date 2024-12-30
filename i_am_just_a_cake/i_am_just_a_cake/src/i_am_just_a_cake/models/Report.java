/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.models;

import i_am_just_a_cake.logic.Helpers;
import i_am_just_a_cake.logic.NoDataFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class Report {
    private int dailyOrdersCnt;
    private Meal MostOrderedMeal;
    private double dailyIncome;
    private User MostRegularCustomer;
    
    public Report(){
    dailyOrdersCnt = 0;
    MostOrderedMeal = null;
    dailyIncome = 0.0 ;
    MostRegularCustomer = null;
    }
    
    
    public int getDailyOrdersCnt() {
        return dailyOrdersCnt;
    }

    public void setDailyOrdersCnt(int dailyOrdersCnt) {
        this.dailyOrdersCnt = dailyOrdersCnt;
    }

    public Meal getMostOrderedMeal() {
        return MostOrderedMeal;
    }

    public void setMostOrderedMeal(Meal MostOrderedMeal) {
        this.MostOrderedMeal = MostOrderedMeal;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public User getMostRegularCustomer() {
        return MostRegularCustomer;
    }

    public void setMostRegularCustomer(User MostRegularCustomer) {
        this.MostRegularCustomer = MostRegularCustomer;
    }
   
    
    public void generateReport(LocalDate date) throws ClassNotFoundException, IOException, NoDataFoundException{
      
       List<Order> ordersList = Order.readAllOrders();
        if(ordersList != null){
              
            List<Meal> mealsList = Meal.readAllMeals();
            List<User> usersList = User.readAllUsers();

            Map<Meal, Integer> mealsMap = new HashMap<>();
            Map<User, Integer> usersMap = new HashMap<>();

            mealsMap = Helpers.fillMapFromList(mealsMap ,mealsList);
            usersMap = Helpers.fillMapFromList(usersMap ,usersList);

            for(Order order : ordersList){
                if(order.getDateTime().toLocalDate().equals(date)){
                    dailyIncome += order.calculateTotalPrice();
                    dailyOrdersCnt ++;
                }

                for(OrderMeal meal : order.getMeals()){
                    if (mealsMap.containsKey(meal.getMeal())) {
     //                   mealsMap.put(meal.getMeal(), mealsMap.get(meal.getMeal()) + meal.getQuantity());
                         mealsMap.put(meal.getMeal(), mealsMap.getOrDefault(meal.getMeal(), 0) + meal.getQuantity());
                    }
                }

                usersMap.put( order.getClient() ,usersMap.getOrDefault(order.getClient(), 0) + 1);

            }

            MostOrderedMeal = Helpers.returnTheKeyWithTheLargestValue(mealsMap);
            MostRegularCustomer = Helpers.returnTheKeyWithTheLargestValue(usersMap);

        }else 
            throw new NoDataFoundException();
    }
   
}
