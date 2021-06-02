package com.mycompany.sisedu;

import com.mycompany.sisedu.controller.TeacherController;
import com.mycompany.sisedu.model.Admin;
import com.mycompany.sisedu.model.Student;
import com.mycompany.sisedu.model.Teacher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Teacher teacher;
    public static Admin admin;
    public static Student student;
    
    
    int ClassId;
    
    
    
    
    public static Scene scene;
    double xOffset, yOffset;
    
    @Override
    public void start(Stage stage) throws Exception{
        scene = new Scene(loadFXML("login"), 1280, 720);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        
//        stage.setResizable(false);
        stage.show();
        scene.setFill(Color.TRANSPARENT);
        
        scene.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        
        scene.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args) {
        launch();
    }
}