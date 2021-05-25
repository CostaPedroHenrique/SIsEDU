package com.mycompany.sisedu.navigation;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.StudantController;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.Studant;
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
import javafx.scene.text.Text;

/**
 *
 * @author pedrohenrique
 */
public class Navigation implements Initializable {
    @FXML
    private Text classLenght;

    @FXML
    private Text teacherLenght;
    
    @FXML
    private TableView<Studant> tableMain;

    @FXML
    private TableColumn<Studant, String> tableStudantName;
    
    @FXML
    private TableColumn<Studant, String> tableStudantEmail;

    ObservableList<Studant> studentList;
    
    @FXML
    public void setViewCreateStudent()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationStudent");
    }
    
    @FXML
    public void setViewCreateTeacher()  throws IOException {
        App.setRoot("registrationTeacher");
    }
    
    
    private void setNumberClass(){
        ClassController classController = new ClassController();
        List<Class> listClass = classController.list();
        
        String classText = "Cadastradas " + Integer.toString(listClass.size());
        classLenght.setText(classText);
        
    }
    
    private void setNumberTeacher(){
        TeacherController teacherController = new TeacherController();
        List<Teacher> listTeacher = teacherController.list();
        
        String teacherText = "Cadastrados " + Integer.toString(listTeacher.size());
        teacherLenght.setText(teacherText);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getElementTable();
        tableStudantName.setCellValueFactory(new PropertyValueFactory<Studant, String>("name"));
        tableStudantEmail.setCellValueFactory(new PropertyValueFactory<Studant, String>("email"));
        
        tableMain.setItems(studentList);

        setNumberClass();
        setNumberTeacher();
    }
    
    private void getElementTable() {
        StudantController studentController = new StudantController();
        List<Studant> studantList = studentController.list();
        studentList = FXCollections.observableArrayList(studantList);
    }
}

//com.mycompany.sisedu.navigation.navigation