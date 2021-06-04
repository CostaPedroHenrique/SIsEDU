package com.mycompany.sisedu.controller.registrationStudent;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.ResultController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.controller.SubjectController;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.Result;
import com.mycompany.sisedu.model.Subject;

import static com.mycompany.sisedu.services.Utils.emailIsValid;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
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
        Student studant = makeStudent();
        if(studant.getName()!=null){
            StudentController studentController = new StudentController();
            studentController.save(studant);
            
            manageResult(studant);
            resetFields();
        }
    }
    
    public void resetFields(){
        name.clear();
        email.clear();
        password.clear();
    }
    
    private void manageResult(Student student){
        SubjectController subjectController = new SubjectController();
        
        List<Subject> subjectList = subjectController.findByClass(student.getClassId().getRegistrationCode());
        ResultController resultController = new ResultController();
        
        for(int i = 0; i< subjectList.size(); i++){
            Result result = new Result();
            result.setNota1(0);
            result.setNota2(0);
            result.setNota3(0);
            result.setNota4(0);
            result.setFinalResult(0);
            result.setStudent(student);
            result.setSubject(subjectList.get(i));
            resultController.save(result);
        }
    }
    
    @FXML
    public void setManageClass()  throws IOException {
        App.setRoot("manageClass");
    }
    
    @FXML
    public void setManageTeacher()  throws IOException {
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
    
    private void RegistrationSuccess(String name){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cadastro Realizado");
        alert.setHeaderText("Estudante " + name + " cadastrado");
        alert.show();
    }
    
    private void RegistrationErro(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cadastro não Realizado");
        alert.setHeaderText("Estudante não cadastrado");
        alert.show();
    }
    
    
    private Student makeStudent(){
        String studentName = name.getText();
        String studentEmail = email.getText();
        String studentPassword = password.getText();
        String hashPassword = Base64.getEncoder().encodeToString(studentPassword.getBytes());
        Class classSelected = className.getSelectionModel().getSelectedItem();
        
        Student studant = new Student();
        if(emailIsValid(studentEmail)){
            studant.setEmail(studentEmail);
            studant.setName(studentName);
            studant.setPassword(hashPassword);
            studant.setClassId(classSelected); 

            RegistrationSuccess(studant.getName());
        }
        else{
            RegistrationErro();
        }
        return studant; 
    }
    
}
