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
public class User {
    private String username;
    private String password;

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

    //todo
     public List<User> read(){
    List<User> users = new LinkedList<>();
        
    
    return users;
    }
    
    public void save(User u){
    }
     
    public void delete(User u){
    }
}
