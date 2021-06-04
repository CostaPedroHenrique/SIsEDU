package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import com.mycompany.sisedu.controller.ClassController;
import com.mycompany.sisedu.controller.StudentController;
import com.mycompany.sisedu.model.Class;
import com.mycompany.sisedu.model.Student;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author pedrohenrique
 */
public class MainClass implements Initializable{
    @FXML
    private Text className;

    @FXML
    private Text lenStudents;

    @FXML
    private Text teacherName;
    
    @FXML
    void viewDetails(MouseEvent event) throws IOException {
        App.setRoot("classDetails");
    }

    @FXML
    void viewFrequency(MouseEvent event) throws IOException {
        App.setRoot("frequency");
    }
    
    @FXML
    public void setLogin()  throws IOException {
        App.setRoot("login");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClassController classController = new ClassController();
        Class classSelected = classController.findByTeacher(App.teacher.getId());
        StudentController studentController = new StudentController();
        List<Student> students = studentController.findByClass(classSelected.getRegistrationCode());
        teacherName.setText(App.teacher.getName());
        className.setText(classSelected.getClassroom());
        lenStudents.setText(Integer.toString(students.size()));
    }
}
