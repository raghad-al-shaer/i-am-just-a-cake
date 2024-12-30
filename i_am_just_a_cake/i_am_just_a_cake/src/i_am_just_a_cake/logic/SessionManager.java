/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i_am_just_a_cake.logic;

import i_am_just_a_cake.models.User;

/**
 *
 * @author ASUS
 */
public class SessionManager {
     private static User loggedInUser ;

    public static void setLoggedInUser (User user) {
        loggedInUser  = user;
    }

    public static User getLoggedInUser () {
        return loggedInUser ;
    }

//    public static boolean isLoggedIn() {
//        return loggedInUser  != null;
//    }

    public static void logout() {
        loggedInUser  = null;
    }
}
