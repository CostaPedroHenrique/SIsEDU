package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.SubjectController;
import com.mycompany.sisedu.model.Frequency;
import com.mycompany.sisedu.model.Subject;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author pedrohenrique
 */
public class ManageDetails implements Initializable  {
    @FXML
    private ComboBox<Subject> subject;
    
    private com.mycompany.sisedu.model.Class className;
    
    private ObservableList<Subject> obsSubject;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClassController classController = new ClassController();
        className = classController.findByTeacher(App.teacher.getId());
        getSubjects();
    }
    
    private void getSubjects(){
        SubjectController subjectController = new SubjectController();
        List<Subject> subjects = subjectController.findByClass(className.getRegistrationCode());
        
        obsSubject = FXCollections.observableArrayList(subjects);
        subject.setItems(obsSubject);
    }

    @FXML
    void setDashboard(MouseEvent event) {

    }

    @FXML
    void upgrade(ActionEvent event) {

    }
    
    public void changed(){
        System.out.println("teste");
    }
    
    @FXML
    public void setLogin()  throws IOException {
        App.setRoot("login");
    }
}
