package com.mycompany.sisedu.navigation;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.Student;
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
    private TableView<Student> tableMain;

    @FXML
    private TableColumn<Student, String> tableStudantName;
    
    @FXML
    private TableColumn<Student, String> tableStudantEmail;
    
    @FXML
    private TableColumn<Student, String> tableClass;

    ObservableList<Student> studentList;
    
    @FXML
    public void setAddStudent()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationStudent");
    }
    
    @FXML
    public void setViewManageTeacher()  throws IOException {
        App.setRoot("manageTeacher");
    }
    
    @FXML
    public void setViewManageClass()  throws IOException {
        App.setRoot("manageClass");
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
        tableStudantName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        tableStudantEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        tableClass.setCellValueFactory(new PropertyValueFactory<Student, String>("classId"));
        
        tableMain.setItems(studentList);

        setNumberClass();
        setNumberTeacher();
    }
    
    private void getElementTable() {
        StudentController studentController = new StudentController();
        List<Student> studantList = studentController.list();
        studentList = FXCollections.observableArrayList(studantList);
    }
}

//com.mycompany.sisedu.navigation.navigation