/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import i_am_just_a_cake.logic.FileManager;
import i_am_just_a_cake.logic.Helpers;
import java.io.IOException;
import java.util.Objects;


/**
 *
 * @author ASUS
 */
public class User implements Serializable {
    private String username;
    private String password;
    private UserRole userRole;
    
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
     public static List<User> readAllUsers()throws  ClassNotFoundException, IOException{
        return FileManager.readFromFile("data/users/users.dat");
    }
    
    public void save()throws ClassNotFoundException ,IOException{
        FileManager.writeObjToFile("data/users/users.dat", this);
    }
     
      public void update(User UpdatedUser)throws  ClassNotFoundException, IOException{//this method is to be called upon the order to be updated
        List<User> usersToUpdate = readAllUsers();
        List<User> updatedUsers = Helpers.updateList(usersToUpdate , this ,UpdatedUser);
        FileManager.writeListToFile("data/meals/meals.dat", updatedUsers);
        
    }
      
    public void delete()throws  ClassNotFoundException, IOException{//this method is to be called upon the Meal to be deleted
        List<User> users = readAllUsers();
        if(users != null && !users.isEmpty()){
        users.removeIf(obj -> obj.equals(this));
        FileManager.writeListToFile("data/meals/meals.dat", users);
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

        User otherUser = (User) obj;

        return this.username.equals(otherUser.username) && this.password.equals(otherUser.password);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        return hash;
    }

}
