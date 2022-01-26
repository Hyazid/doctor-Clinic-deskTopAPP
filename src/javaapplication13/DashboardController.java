/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class DashboardController implements Initializable {

    @FXML
    private JFXButton dashboard;
    @FXML
    private JFXButton settings;
    @FXML
    private JFXButton options;
    @FXML
    private JFXButton about;
    @FXML
    private Label dashboard_label;
    @FXML
    private Label userDoctor;
    private String password;
    private String user;

    /**
     * Initializes the controller class.
     */
    FXMLController fx= new FXMLController(); 
    @FXML
    private BorderPane contentArea;
    @FXML
    private Pane pane;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       dashboard_label.setText("Dashboard");
     
    }
    
     public String getPassword(){
        return password;
    }
    public String getUser(){
        return user; 
    }
     public void setPassword(String password){
        this.password= password;
    }
    public void setUser(String user){
        this.user=user; 
    }
    public void setDocLable(String text){
        userDoctor.setText(text);
    }

    @FXML
    private void dashboardClick(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            pane.getChildren().removeAll(); 
            pane.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SettingsClicks(ActionEvent event) {
        try {
            Parent  fxml = FXMLLoader.load(getClass().getResource("settings.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml); 
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void optionClick(ActionEvent event) {
          try {
            Parent  fxml = FXMLLoader.load(getClass().getResource("option.fxml"));
            pane.getChildren().removeAll();
            pane.getChildren().setAll(fxml); 
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void about(ActionEvent event) {
    }
    
 
    
    
}
