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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private TableColumn<Student, Integer> tableStudantId;
    
    @FXML
    private TableColumn<Student, String> tableStudantName;
    
    @FXML
    private TableColumn<Student, String> tableStudantEmail;
    
    @FXML
    private TableColumn<Student, String> tableClass;
    
    @FXML
    private TableColumn<?, ?> tableOptions;

    
    
    
    @FXML
    private TextField editName;

    @FXML
    private TextField editEmail;
    
    
    String password;
    
    int id;
    
    int index = -1;
    
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
        tableStudantName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        tableStudantId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("registrationcode"));
        tableStudantEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        tableClass.setCellValueFactory(new PropertyValueFactory<Student, String>("classId"));
        getElementTable();
        
        
//        tableOptions.setCellValueFactory(new PropertyValueFactory<Student, String>("classId"));
//        tableMain.setItems(studentList);

        setNumberClass();
        setNumberTeacher();
    }
    
    private void getElementTable() {
        ObservableList<Student> studentList;
        StudentController studentController = new StudentController();
        List<Student> studantList = studentController.list();
        studentList = FXCollections.observableArrayList(studantList);
        tableMain.setItems(studentList);
    }
    
    
    
    @FXML
    void getSelected(MouseEvent event){
        index = tableMain.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        
        editName.setText(tableStudantName.getCellData(index));
        editEmail.setText(tableStudantEmail.getCellData(index));
        
        id = tableStudantId.getCellData(index);
    }
    
    @FXML
    void handleEdit()  throws IOException {
        Student editStudent = new Student();
        StudentController studentController = new StudentController();
        
        editStudent = studentController.find(id);
        
        String name = editName.getText();
        String email = editEmail.getText();

        editStudent.setName(name);
        editStudent.setEmail(email);
        
        studentController.save(editStudent);
        
        getElementTable();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Aluno editado");
        alert.setHeaderText("Aluno com a matrícula: " + id + "foi alterado");
        alert.setContentText("Continue gerenciando.");
        alert.show();
        
        App.setRoot("secondary");
    }
    
    
    @FXML
    public void setLogin()  throws IOException {
        App.setRoot("login");
    }
}

//com.mycompany.sisedu.navigation.navigation