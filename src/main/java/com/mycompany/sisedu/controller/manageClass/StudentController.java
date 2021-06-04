/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.ResultController;
import com.mycompany.sisedu.model.Result;
import com.mycompany.sisedu.model.Subject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author pedrohenrique
 */
public class StudentController implements Initializable {
    @FXML
    private TableView<Result> mainTable;

    @FXML
    private TableColumn<Result, String> tableSubject;

    @FXML
    private TableColumn<Result, Double> tableNote1;

    @FXML
    private TableColumn<Result, Double> tableNote2;

    @FXML
    private TableColumn<Result, Double> tableNote3;

    @FXML
    private TableColumn<Result, Double> tableNote4;

    @FXML
    private TableColumn<Result, Double> tableMean;

    @FXML
    private Text className;

    @FXML
    private Text studentName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        studentName.setText(App.student.getName());
        className.setText(App.student.getClassId().getClassroom());

       
        tableSubject.setCellValueFactory(new PropertyValueFactory<Result, String>("subject"));
        tableNote1.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota1"));
        tableNote2.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota2"));
        tableNote3.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota3"));
        tableNote4.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota4"));
        tableMean.setCellValueFactory(new PropertyValueFactory<Result, Double>("mean"));
        getTable();
    }
    
    @FXML
    public void setLogin() throws IOException{
        App.setRoot("login");
    }
    
    
    private void getTable(){
        ResultController resultController = new ResultController();
        
        List<Result> results = resultController.findByStudent(App.student.getRegistrationcode());
        
        ObservableList<Result> resultList = FXCollections.observableArrayList(results);
        mainTable.setItems(resultList); 
        
    }
}
