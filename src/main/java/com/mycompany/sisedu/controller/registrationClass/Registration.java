package com.mycompany.sisedu.controller.registrationClass;
import com.mycompany.sisedu.controller.registrationStudent.*;
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
import static java.lang.Integer.parseInt;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

/**
 *
 * @author pedrohenrique
 */
public class Registration implements Initializable{
    
    @FXML
    private Button students;

    @FXML
    private Button teachers;

    @FXML
    private TextField className;

    @FXML
    private TextField classLimit;

    @FXML
    private ComboBox<String> shift;

    @FXML
    private ComboBox<?> active;

    @FXML
    private void save() {
        SchoolController schoolController = new SchoolController();
        School school = schoolController.find(1);
        String name = className.getText();
        int limit = parseInt(classLimit.getText());
        String shiftSelected = (String) shift.getSelectionModel().getSelectedItem();
        Class classs = new Class();
        classs.setActive(true);
        classs.setClassroom(name);
        classs.setCapacityStudents(limit);
        classs.setShift(shiftSelected);
        classs.setSchool(school);
        
        ClassController classController = new ClassController();
        classController.save(classs);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cadastro Realizado");
        alert.setHeaderText("Turma " +  name + " cadastrado");
        alert.show();
        
        resetFields();
    }
    
    public void resetFields(){
        className.clear();
        classLimit.clear();
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
    public void setMain()  throws IOException {
        App.setRoot("secondary");
    }
//
//
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadShift();
    }
//    
//        
    private void loadShift(){
        ObservableList shifts = FXCollections.observableArrayList ("Matutíno", "Vespertino", "Noturno");
        
        shift.setItems(shifts);
    }
}
