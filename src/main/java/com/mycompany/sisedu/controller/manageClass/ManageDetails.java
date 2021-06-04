package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.ResultController;
import com.mycompany.sisedu.controller.SubjectController;
import com.mycompany.sisedu.model.Result;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author pedrohenrique
 */
public class ManageDetails implements Initializable  {
    
    @FXML
    private Text classNameField;
    
    @FXML
    private Text studantNameSelected;
    
    @FXML
    private TableView<Result> mainTable;

    @FXML
    private TableColumn<Result, String> tableName;

    @FXML
    private TableColumn<Result, Double> tableAbsences;

    @FXML
    private TableColumn<Result, Double> tableNote1;

    @FXML
    private TableColumn<Result, Double> tableNote2;

    @FXML
    private TableColumn<Result, Double> tableNote3;

    @FXML
    private TableColumn<Result, Double> tableNote4;

    @FXML
    private TableColumn<Result, Double> tableMean;

    @FXML
    private TableColumn<Result, Double> tableFinal;

    @FXML
    private TableColumn<Result, Integer> tableId;

    @FXML
    private TextField note1;

    @FXML
    private TextField note2;

    @FXML
    private TextField note3;

    @FXML
    private TextField note4;
    
    int index = -1;
    int idResultSelected = -1;

    @FXML
    private ComboBox<Subject> subject;
    
    private com.mycompany.sisedu.model.Class className;
    
    private ObservableList<Subject> obsSubject;
    
    ObservableList<Result> studentList;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClassController classController = new ClassController();
        className = classController.findByTeacher(App.teacher.getId());
        
        classNameField.setText(className.getClassroom());
        
        tableId.setCellValueFactory(new PropertyValueFactory<Result, Integer>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<Result, String>("student"));
        tableNote1.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota1"));
        tableNote2.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota2"));
        tableNote3.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota3"));
        tableNote4.setCellValueFactory(new PropertyValueFactory<Result, Double>("nota4"));
        tableMean.setCellValueFactory(new PropertyValueFactory<Result, Double>("mean"));
        tableFinal.setCellValueFactory(new PropertyValueFactory<Result, Double>("finalResult"));
        
//        getTable();
        getSubjects();
    }
    
    private void getSubjects(){
        SubjectController subjectController = new SubjectController();
        List<Subject> subjects = subjectController.findByClass(className.getRegistrationCode());
        
        obsSubject = FXCollections.observableArrayList(subjects);
        subject.setItems(obsSubject);
    }
    
    
    private void getTable(){
        ResultController resultController = new ResultController();
        Subject subjectSelected = subject.getSelectionModel().getSelectedItem();
        if(subjectSelected != null){
            List<Result> resultListNotes = resultController.findBySubject(subjectSelected.getRegistrationCode());
            if(studentList != null){
                studentList.removeAll(studentList);
            }
            studentList = FXCollections.observableArrayList(resultListNotes);
            mainTable.setItems(studentList); 
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione uma Disciplina");
            alert.show();
        }
    }
    

    @FXML
    void changed() {
        getTable();
    }
    
    @FXML
    void getSelected(MouseEvent event){
        
        index = mainTable.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        note1.setText(Double.toString(tableNote1.getCellData(index)));
        note2.setText(Double.toString(tableNote2.getCellData(index)));
        note3.setText(Double.toString(tableNote3.getCellData(index)));
        note4.setText(Double.toString(tableNote4.getCellData(index)));
        idResultSelected = tableId.getCellData(index);
        
        
    }
    
    @FXML
    void setLogin(MouseEvent event) throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    void setDashboard(MouseEvent event) throws IOException {
        App.setRoot("classMain");
    }
    
    
    void resetFields(){
        note1.clear();
        note2.clear();
        note3.clear();
        note4.clear();
    }
    
    
    
    @FXML
    void upgrade(ActionEvent event) {
        ResultController resultController = new ResultController();
        Double Doublenote1 = Double.parseDouble(note1.getText());
        Double Doublenote2 = Double.parseDouble(note2.getText());
        Double Doublenote3 = Double.parseDouble(note3.getText());
        Double Doublenote4 = Double.parseDouble(note4.getText());
        
        Double mean = meanResult(Doublenote1, Doublenote2, Doublenote3, Doublenote4);
        
        if(idResultSelected != -1){
            Result resultSelected = resultController.find(idResultSelected);
            if(resultSelected != null){
                resultSelected.setNota1(Doublenote1);
                resultSelected.setNota2(Doublenote2);
                resultSelected.setNota3(Doublenote3);
                resultSelected.setNota4(Doublenote4);
                resultSelected.setMean(mean);
                
                resultController.save(resultSelected);
            }
        }
        
        
        getTable();
        resetFields();
        studantNameSelected.setText("");
        idResultSelected = -1;
    }
    
    
    private double meanResult(double n1, double n2, double n3, double n4){
        double mean = 0;
        int count = 0;
        
        if(n1>0){
            mean = n1+mean;
            count += 1;
         };
         
         if(n2>0){
            mean = n2+mean;
            count += 1;
         };
         
         if(n3>0){
            mean = n3+mean;
            count += 1;
         };
         if(n4>0){
            mean = n4+mean;
            count += 1;
         };
         
         if(count == 0){
             return 0;
         }
        
        return mean/4;
    }
}
