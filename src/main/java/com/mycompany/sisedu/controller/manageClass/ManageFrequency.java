package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.FrequencyController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.controller.SubjectController;
import com.mycompany.sisedu.model.Frequency;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.Subject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author pedrohenrique
 */
public class ManageFrequency implements Initializable {
    
    @FXML
    private TableView<Frequency> mainTable;

    @FXML
    private TableColumn<Frequency, Boolean> present;

    @FXML
    private TableColumn<Frequency, String> student;
    

    @FXML
    private ComboBox<Subject> subject;
    
    private Class className;
    
    private ObservableList<Subject> obsSubject;

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void setDashboard(MouseEvent event) throws IOException {
        App.setRoot("classMain");
    }

    @FXML
    void setMain(MouseEvent event) throws IOException {
        App.setRoot("classMain");

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClassController classController = new ClassController();
        className = classController.findByTeacher(App.teacher.getId());
        
        student.setCellValueFactory(new PropertyValueFactory<Frequency, String>("student"));
        present.setCellValueFactory(new PropertyValueFactory<Frequency, Boolean>("present"));
        
        present.setCellFactory(CheckBoxTableCell.forTableColumn(present));
        
        getTable();
        getSubjects();
    }
    
    private void getSubjects(){
        SubjectController subjectController = new SubjectController();
        List<Subject> subjects = subjectController.findByClass(className.getRegistrationCode());
        
        obsSubject = FXCollections.observableArrayList(subjects);
        subject.setItems(obsSubject);
    }
    
    
    private void getTable(){
        ObservableList<Frequency> obsFrequencyList;
        
        Date now = new Date();
        StudentController studentController = new StudentController();
        
        List<Frequency> frequencyList = new ArrayList<Frequency>();
        
        List<Student> studentList = studentController.findByClass(className.getRegistrationCode());
        
        for(int i = 0; i< studentList.size(); i++){
            Frequency frequency = new Frequency();
            
            frequency.setPresent(true);
            frequency.setStudent(studentList.get(i));
//            frequency.setSubject(subject);
            frequency.setDate(now);
            
            frequencyList.add(frequency);
        }
        
        obsFrequencyList = FXCollections.observableArrayList(frequencyList);
        mainTable.setItems(obsFrequencyList);
    }
    
    @FXML
    private void makeFrequency(){
        Subject subjectSelected = subject.getSelectionModel().getSelectedItem();
        if(subjectSelected != null){
            int tableLength = mainTable.getItems().size();

            for(int i=0; i<tableLength; i++){
                Frequency frequency = new Frequency();
                FrequencyController frequencyController = new FrequencyController();
                System.out.println(mainTable.getItems().get(i).getStudent().getName());
                System.out.println(mainTable.getItems().get(i).isPresent());
            }
            System.out.println(mainTable.getItems().size());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione uma Disciplina");
            alert.show();
        }
        
    }
    
    
    @FXML
    public void setLogin()  throws IOException {
        App.setRoot("login");
    }
    
}
