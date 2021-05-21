/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisedu.navigation;

import com.mycompany.sisedu.App;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author pedrohenrique
 */
public class Navigation {
    @FXML
    public void setViewCreateStudent()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationStudent");
    }
    
    @FXML
    public void setViewCreateTeacher()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationTeacher");
    }
    
    
}

//com.mycompany.sisedu.navigation.navigation