package com.mycompany.sisedu.controller.login;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.AdminController;
import com.mycompany.sisedu.model.Admin;
import com.mycompany.sisedu.model.Student;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private void login() throws IOException, NoSuchAlgorithmException {
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        String registrationValue = registration.getText();
        String passwordValue = password.getText();
        
        String hashPassword = Base64.getEncoder().encodeToString(passwordValue.getBytes());

         
        getAdmin(registrationValue, hashPassword);
    }

    private void accessDanieded(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Acesso negado");
        alert.setHeaderText("Verifique se os dados inseridos estão corretos");
        alert.setContentText("Verifique se marcou o tipo de usuário correto");
        alert.show();
    }
    
     private void accessPermited(String name){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bem vindo");
        alert.setHeaderText("Seja bem vindo(a): " + name);
        alert.show();
    }
    
    
    private void getAdmin( String registration, String password ) throws IOException{
        int i;
        List<Admin> admins;
        AdminController controller = new AdminController();
        admins = controller.find( registration, password );
        if (admins.size() > 0) {
            Admin admin = admins.get(0);
            App.setRoot("secondary");
            
        }
        else {
            accessDanieded();
        }
        
    }
    

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
}
