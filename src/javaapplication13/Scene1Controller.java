/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class Scene1Controller implements Initializable {

    @FXML
    private Pane paneForForm;
    @FXML
    private AnchorPane generalPaneRDV;
    Pane    pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addConsultation(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("addconsultation.fxml"));
            paneForForm.getChildren().removeAll();
            paneForForm.getChildren().addAll(fxml); 
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void editConsult(ActionEvent event) {
        try {
            Parent fxml= FXMLLoader.load(getClass().getResource("editConsult.fxml"));
            paneForForm.getChildren().removeAll();
            paneForForm.getChildren().addAll(fxml);
            
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void soncultModification(ActionEvent event) {
        try {
            Parent fxml= FXMLLoader.load(getClass().getResource("editConsult.fxml"));
            paneForForm.getChildren().removeAll();
            paneForForm.getChildren().addAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addRDV(ActionEvent event) {
       
        try {
            /*try {
            FXMLLoader fxml = new  FXMLLoader();
            fxml.setLocation(getClass().getResource("addRDV.fxml"));
            DialogPane pane = fxml.load(); 
            
            AddRDVController adv= fxml.getController();
            Dialog<ButtonType> dialog = new Dialog<>(); 
            dialog.setDialogPane(pane);
            dialog.setTitle("Insert new RDV");
            
            Optional<ButtonType> clickedButton= dialog.showAndWait();
            if(clickedButton.get()==ButtonType.APPLY){
            System.out.print(("show window"));
            System.out.print(("show window--->"));
            
            }
            else{
            dialog.close();
            }
            
            
            } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            FXMLLoader loader= new FXMLLoader(getClass().getResource("addRDV.fxml"));
            Parent root =(Parent)loader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("add new RDV");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
      
        
          
            
            
        
        
        
        
    }

    @FXML
    private void editRDV(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("editRDV.fxml"));
            Parent root =(Parent)loader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("SELECT  RDV YOU want to change");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deletRDV(ActionEvent event) {
    }

    @FXML
    private void printRDV(ActionEvent event) {
    }
    
    
}
