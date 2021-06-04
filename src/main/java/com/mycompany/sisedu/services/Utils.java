package com.mycompany.sisedu.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pedrohenrique
 */
public class Utils {
    public static boolean emailIsValid(String email){
        String regex = "^(.+)@(.+)$";
 
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
