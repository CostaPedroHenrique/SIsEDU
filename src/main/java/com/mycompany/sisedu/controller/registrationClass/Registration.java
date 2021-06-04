package com.mycompany.sisedu.controller.registrationClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.SchoolController;
import com.mycompany.sisedu.controller.SubjectController;
import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Teacher;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.School;
import com.mycompany.sisedu.model.Subject;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<Teacher> teacher;

    @FXML
    private ComboBox<?> active;
    
    private ObservableList<Teacher> obsTeacher;

    @FXML
    private void save() {
        SchoolController schoolController = new SchoolController();
        School school = schoolController.find(1);
        String name = className.getText();
        int limit = parseInt(classLimit.getText());
        
        String shiftSelected = (String) shift.getSelectionModel().getSelectedItem();
        Teacher teacherSelected = teacher.getSelectionModel().getSelectedItem();
        
        Class classs = new Class();
        classs.setActive(true);
        classs.setClassroom(name);
        classs.setCapacityStudents(limit);
        classs.setShift(shiftSelected);
        classs.setTeacher(teacherSelected);
        classs.setSchool(school);
        
        ClassController classController = new ClassController();
        classController.save(classs);
        
        addSubjects(classs);
        
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
    public void setManageTeacher()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageTeacher");
    }
    
    @FXML
    public void setManageClass()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageClass");
    }
    
    @FXML
    public void setMain()  throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    public void setLogin()  throws IOException {
        App.setRoot("login");
    }
//
//
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadShift();
        loadTeachers();
    }
//    
//        
    private void loadShift(){
        ObservableList shifts = FXCollections.observableArrayList ("Matutíno", "Vespertino", "Noturno");
        shift.setItems(shifts);
    }
    
    private void loadTeachers(){
        TeacherController teacherController = new TeacherController();
        List<Teacher> teacherList = teacherController.list();
        
        obsTeacher = FXCollections.observableArrayList(teacherList);
        teacher.setItems(obsTeacher);
    }
    
    private void addSubjects(Class CLASS){

        Subject subject = new Subject();
        SubjectController subjectController = new SubjectController();
        
        subject.setClassId(CLASS);
        subject.setMenu("Está disciplina é boa!!");
        subject.setName("Português");
        subject.setWorkload(80);
        subjectController.save(subject);
        
        Subject subject2 = new Subject();
        
        subject2.setClassId(CLASS);
        subject2.setMenu("Está disciplina é melhor ainda!!");
        subject2.setName("Matemática");
        subject2.setWorkload(80);
        subjectController.save(subject2);
    }
    
}
