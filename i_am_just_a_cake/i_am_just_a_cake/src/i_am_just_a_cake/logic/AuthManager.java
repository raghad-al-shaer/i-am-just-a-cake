/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.logic;

import i_am_just_a_cake.models.User;
import i_am_just_a_cake.models.UserRole;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AuthManager {
    
    public static UserRole register(User user)throws InvalidUsernameException,ClassNotFoundException, IOException{
        List<User> users = User.readAllUsers();
        for (User  u : users) {
            if ( user.getUsername().equals( u.getUsername() ) ) {
                throw new InvalidUsernameException("sorry , username already taken !");
            }
        }
        user.save();
        SessionManager.setLoggedInUser(user);
        return user.getUserRole();
    }
    
    public static UserRole login(User user) throws InvalidCredentialsException,ClassNotFoundException, IOException {
        List<User> users = User.readAllUsers();
        for (User  u : users) {
            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                SessionManager.setLoggedInUser(user);
                return u.getUserRole();
            }
        }
        throw new InvalidCredentialsException("Invalid username or password");
    }
    
//     public static UserRole deleteAccount(User u){//login first //then delete}
    public static void logout(){
        SessionManager.logout();
    }
    
}
