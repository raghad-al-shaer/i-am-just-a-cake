/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.logic;

import i_am_just_a_cake.models.Meal;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class Helpers {
    
    
    public static <T> List<T> updateList(List<T> listToUpdate ,T oldObj ,T newObj){
         if (listToUpdate != null && !listToUpdate.isEmpty()) {
            for (int i = 0; i < listToUpdate.size(); i++) {
                if (listToUpdate.get(i).equals(oldObj)) {
                    listToUpdate.set(i, newObj);
                    break; 
                }
            }
        }
        return listToUpdate; 
    }
    
    public static boolean checkMealNameIsUnique(List<Meal> mealsList ,Meal newObj ){
      if (mealsList != null && !mealsList.isEmpty() && newObj != null) {
            for (int i = 0; i < mealsList.size(); i++) {
                if (mealsList.get(i).getName().equals(newObj.getName())) {
                    return false;
                }
            }
      }
      return true;
    }
    
    public static <K> Map<K, Integer> fillMapFromList(Map<K, Integer> map, List<K> list) {
        for (K element : list) {
            map.put(element, 0); // Initialize the value to 0
        }
        return map;
    }
    
    public static <T> T returnTheKeyWithTheLargestValue(Map<T, Integer> map){
       
        T maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
//    
//    public static <T> List<T> deleteFromList(List<T> listToDeleteFrom , T objToBeDeleted){
//        if (listToDeleteFrom != null && !listToDeleteFrom.isEmpty()) {
//            // Iterate through the list to find the object to be deleted
//            listToDeleteFrom.removeIf(obj -> obj.equals(objToBeDeleted));
//        }
//        return listToDeleteFrom;
//    }
}
