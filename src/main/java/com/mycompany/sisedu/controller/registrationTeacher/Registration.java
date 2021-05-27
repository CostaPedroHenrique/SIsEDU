package com.mycompany.sisedu.controller.registrationTeacher;
import com.mycompany.sisedu.App;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Teacher;
import java.io.IOException;
import java.util.Base64;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author pedrohenrique
 */
public class Registration {
    
    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    void save() {
        System.out.println("chegou aqui");
        String teacherName = name.getText();
        String teacherEmail = email.getText();
        String teacherPassword = password.getText();
        String hashPassword = Base64.getEncoder().encodeToString(teacherPassword.getBytes());
        
        Teacher teacher = new Teacher();
        teacher.setEmail(teacherEmail);
        teacher.setName(teacherName);
        teacher.setPassword(hashPassword);
        
        TeacherController teacherController = new TeacherController();
        teacherController.save(teacher);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cadastro Realizado");
        alert.setHeaderText("Professor " + teacherName + " cadastrado");
        alert.show();
        resetFields();
    }
    
    public void resetFields(){
        name.clear();
        email.clear();
        password.clear();
    }
    
    @FXML
    public void setManageClass()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageClass");
    }
   
    
    @FXML
    public void setAddStudent()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationStudent");
    }
    
    @FXML
    public void setManageTeacher()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageTeacher");
    }
    
    @FXML
    public void setMain()  throws IOException {
        System.out.println("testes");
        App.setRoot("secondary");
    }
}
