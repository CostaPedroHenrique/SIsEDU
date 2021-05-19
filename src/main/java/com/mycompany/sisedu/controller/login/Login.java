package com.mycompany.sisedu.controller.login;

import com.mycompany.sisedu.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author pedrohenrique
 */
public class Login {
    
    @FXML
    private TextField registration;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private ToggleGroup group;

    @FXML
    private void login() throws IOException {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        
        System.out.println("Matricula: " + registration.getText());
        System.out.println("Senha: " + password.getText());
        System.out.println(toogleGroupValue);
        App.setRoot("secondary");
        

    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
}
