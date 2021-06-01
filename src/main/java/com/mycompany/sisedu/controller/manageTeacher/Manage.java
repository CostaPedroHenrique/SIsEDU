/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisedu.controller.manageTeacher;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Teacher;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author pedrohenrique
 */
public class Manage implements Initializable {
    
    @FXML
    private TableColumn<Teacher, String> tableName;

    @FXML
    private TableColumn<Teacher, String> tableEmail;
    
    @FXML
    private TableView<Teacher> tableMain;
    
    ObservableList<Teacher> teacherList;

    
    @FXML
    public void setMain()  throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    public void setAddStudent()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationStudent");
    }
    
    @FXML
    public void setAddTeacher()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationTeacher");
    }
    
    @FXML
    public void setManageClass()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageClass");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getElementTable();
        tableName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<Teacher, String>("email"));
        
        tableMain.setItems(teacherList);

    }
    
    private void getElementTable() {
        TeacherController teacherController = new TeacherController();
        List<Teacher> listTeacher = teacherController.list();
        teacherList = FXCollections.observableArrayList(listTeacher);
    }  
}
