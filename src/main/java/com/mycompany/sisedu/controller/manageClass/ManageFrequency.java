package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.FrequencyController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.model.Frequency;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Class;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableView<Student> mainTable;

    @FXML
    private TableColumn<Frequency, Boolean> present;

    @FXML
    private TableColumn<Student, String> student;
    
    @FXML
    private TableColumn<Student, Integer> id;

    @FXML
    private ComboBox<Frequency> className;

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
        student.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("registrationcode"));
        
//        present.setCellValueFactory(new PropertyValueFactory<Frequency, Boolean>("present"));
        
        present.setCellFactory(
                CheckBoxTableCell.forTableColumn(present));

        getElementTable();
        
        
//        tableOptions.setCellValueFactory(new PropertyValueFactory<Student, String>("classId"));
//        tableMain.setItems(studentList);

 
    }
    
    private void getElementTable() {
        ObservableList<Student> studentList;
        StudentController studentController = new StudentController();
        List<Student> studantList = studentController.list();
        studentList = FXCollections.observableArrayList(studantList);
        mainTable.setItems(studentList);
    }
    
    
    private void getTable(){
        Date now = new Date();
        StudentController studentController = new StudentController();
        List<Student> studentList = studentController.list();
        List<Frequency> frequencyList;
        
        ClassController classController = new ClassController();
        Class className = classController.find(1);
        
        for(int i = 0; i< studentList.size(); i++){
            Frequency frequency = new Frequency();
            
            frequency.setPresent(false);
            frequency.setStudent(studentList.get(i));
//            frequency.setSubject(subject);
            frequency.setDate(now);
            
//            frequencyList.add(frequency);
        }
    }
    
    @FXML
    private void makeFrequency(){
        int tableLength = mainTable.getItems().size();
        
        for(int i=0; i<tableLength; i++){
            Frequency frequency = new Frequency();
            FrequencyController frequencyController = new FrequencyController();
            System.out.println(id.getCellData(i));
            System.out.println(student.getCellData(i));
            System.out.println(present.getCellData(i));
        }
        System.out.println(mainTable.getItems().size());
    }
    
}
