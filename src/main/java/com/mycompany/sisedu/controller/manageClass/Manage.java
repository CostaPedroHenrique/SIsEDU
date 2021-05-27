package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Class;
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

/**
 *
 * @author pedrohenrique
 */
public class Manage implements Initializable {
    
    @FXML
    private TableView<Class> mainTable;

    @FXML
    private TableColumn<Class, String> tableName;
    
    @FXML
    private TableColumn<Class, Integer> tableCapacity;

    @FXML
    private TableColumn<Class, String> tableShift;
    
    
    ObservableList<Class> classListObservable;

    
    @FXML
    public void setMain()  throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    public void setAddStudent()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationStudent");
    }
    
    @FXML
    public void setAddClass()  throws IOException {
        System.out.println("testes");
        App.setRoot("registrationClass");
    }
    
    @FXML
    public void setManageTeacher()  throws IOException {
        System.out.println("testes");
        App.setRoot("manageTeacher");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getElementTable();
        tableName.setCellValueFactory(new PropertyValueFactory<Class, String>("classroom"));
        tableCapacity.setCellValueFactory(new PropertyValueFactory<Class, Integer>("capacityStudents"));
        tableShift.setCellValueFactory(new PropertyValueFactory<Class, String>("shift"));
        
        mainTable.setItems(classListObservable);

    }
    
    private void getElementTable() {
        ClassController classController = new ClassController();
        List<Class> classList = classController.list();
        classListObservable = FXCollections.observableArrayList(classList);
    }
}
