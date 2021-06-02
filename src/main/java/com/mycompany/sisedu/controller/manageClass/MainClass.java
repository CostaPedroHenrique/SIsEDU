package com.mycompany.sisedu.controller.manageClass;

import com.mycompany.sisedu.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author pedrohenrique
 */
public class MainClass {
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
}
