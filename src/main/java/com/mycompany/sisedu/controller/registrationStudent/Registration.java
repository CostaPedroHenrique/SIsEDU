package com.mycompany.sisedu.controller.registrationStudent;
import com.mycompany.sisedu.controller.registrationTeacher.*;
import com.mycompany.sisedu.App;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.SchoolController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Teacher;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.School;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

/**
 *
 * @author pedrohenrique
 */
public class Registration implements Initializable{
    
    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<Class> className;
    
    private ObservableList<Class> obsClass;

    @FXML
    private void save() {    
        String studentName = name.getText();
        String studentEmail = email.getText();
        String studentPassword = password.getText();
        String hashPassword = Base64.getEncoder().encodeToString(studentPassword.getBytes());
        Class classSelected = className.getSelectionModel().getSelectedItem();
        
        Student studant = new Student();
        
        studant.setEmail(studentEmail);
        studant.setName(studentName);
        studant.setPassword(hashPassword);
        studant.setClassId(classSelected);  
        
        StudentController studentController = new StudentController();
        System.out.println(studant.getRegistrationCode());
        System.out.println(studant.getName());
        System.out.println(studant.getEmail());
        System.out.println(studant.getPassword());
        System.out.println(studant.getClassId().getClassroom());


        studentController.save(studant);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cadastro Realizado");
        alert.setHeaderText("Estudante " + studentName + " cadastrado");
        alert.show();
        resetFields();
    }
    
    public void resetFields(){
        name.clear();
        email.clear();
        password.clear();
    }
    
    private void manageResult(Student student){
        
    }
    
    @FXML
    public void setManageClass()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageClass");
    }
    
    @FXML
    public void setManageTeacher()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageTeacher");
    }
    
    @FXML
    public void setMain()  throws IOException {
        App.setRoot("secondary");
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadClass();
    }
    
        
    private void loadClass(){
        ClassController classController = new ClassController();
        List<Class> classList = classController.list();
        
        obsClass = FXCollections.observableArrayList(classList);
        className.setItems(obsClass);
    }
    
    @FXML
    public void setLogin()  throws IOException {
        App.setRoot("login");
    }
}
