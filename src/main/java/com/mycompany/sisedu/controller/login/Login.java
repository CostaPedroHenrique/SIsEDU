package com.mycompany.sisedu.controller.login;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.AdminController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Admin;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Teacher;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
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
        System.out.println("Chegou aqui essa caceta");
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        String registrationValue = registration.getText();
        String passwordValue = password.getText();
        System.out.println(toogleGroupValue);
        String hashPassword = Base64.getEncoder().encodeToString(passwordValue.getBytes());

        
        if(emailIsValid(registrationValue)){
            if(toogleGroupValue.equals("Administrador")){
                getAdmin(registrationValue, hashPassword);  
            }
            else if (toogleGroupValue.equals("Professor")) {
                getTeacher(registrationValue, hashPassword);
            }
            else {
                getStudent(registrationValue, hashPassword);
            }
        }
        else{
            emailInvalid();
        }
    }

    private void accessDanieded(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Acesso negado");
        alert.setHeaderText("Verifique se os dados inseridos estão corretos");
        alert.setContentText("Verifique se o email é válido");
        alert.show();
    }
    
    private void emailInvalid(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Acesso negado");
        alert.setHeaderText("Email inválido");
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
        if (admins.size() > 0 ) {
            Admin admin = admins.get(0);
            App.admin = admin;
            App.setRoot("secondary");
            
        }
        else {
            accessDanieded();
        }
        
    }
    
    private void getTeacher( String registration, String password ) throws IOException{
        int i;
        List<Teacher> teachers;
        TeacherController controller = new TeacherController();
        teachers = controller.find( registration, password );
        if (teachers.size() > 0 ) {
            Teacher teacher = teachers.get(0);
            App.teacher = teacher;
            App.setRoot("classMain");
        }
        else {
            accessDanieded();
        }
    }
    
    private void getStudent( String registration, String password ) throws IOException{
        int i;
        List<Student> students;
        StudentController controller = new StudentController();
        students = controller.find( registration, password );
        if (students.size() > 0 ) {
            Student student = students.get(0);
            App.student = student;
            App.setRoot("dashboardStudent");
            
        }
        else {
            accessDanieded();
        } 
    }
    
    
    private boolean emailIsValid(String email){
        String regex = "^(.+)@(.+)$";
 
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
}
