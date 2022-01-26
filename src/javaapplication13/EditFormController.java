/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;


/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class EditFormController implements Initializable {
     @FXML
    private TextField nameFieldToEdit;
    @FXML
    private Pane alertBoxPane;
    @FXML
    private TextField lastNameFiedToEdit;
    @FXML
    private TextField ageFiledToEdit;
    @FXML
    private TextField blodTypeFieldToEdit;
    @FXML
    private JFXTextArea diagnosticTextAreacToEdit;
    @FXML
    private JFXTextArea historicTextAreaToEdit;
    public TextField getNameFieldToEdit() {
        return nameFieldToEdit;
    }
    public TextField getLastNameFiedToEdit() {
        return lastNameFiedToEdit;
    }
    public TextField getAgeFiledToEdit() {
        return ageFiledToEdit;
    }
    public TextField getBlodTypeFieldToEdit() {
        return blodTypeFieldToEdit;
    }
    public JFXTextArea getDiagnosticTextAreacToEdit() {
        return diagnosticTextAreacToEdit;
    }
    public JFXTextArea getHistoricTextAreaToEdit() {
        return historicTextAreaToEdit;
    }
    public void setNameFieldToEdit(String nameFieldToEdit) {
       this.nameFieldToEdit.setText(nameFieldToEdit);
    }
    public void setLastNameFiedToEdit(String lastNameFiedToEdit) {
       this.lastNameFiedToEdit.setText(lastNameFiedToEdit);
    }
    public void setAgeFiledToEdit(String ageFiledToEdit) {
        this.ageFiledToEdit.setText(ageFiledToEdit);
    }
    public void setBlodTypeFieldToEdit(String blodTypeFieldToEdit) {
      this.blodTypeFieldToEdit.setText(blodTypeFieldToEdit);
    }
    public void setDiagnosticTextAreacToEdit(String diagnosticTextAreacToEdit) {
        this.diagnosticTextAreacToEdit.setText(diagnosticTextAreacToEdit);
    }
    public void setHistoricTextAreaToEdit(String historicTextAreaToEdit) {
        this.historicTextAreaToEdit.setText(historicTextAreaToEdit);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    @FXML
    private void saveModification(ActionEvent event) {
        System.out.println("name"+this.getNameFieldToEdit().getText()+"-->lastName"+this.getLastNameFiedToEdit().getText());
      
      
        ConnectionDBTools.updateAfterModificationPatietInfo
        (
                this.getNameFieldToEdit().getText(),this.getLastNameFiedToEdit().getText(),
                this.getBlodTypeFieldToEdit().getText(),
                this.getHistoricTextAreaToEdit().getText(),
                Integer.parseInt(this.getAgeFiledToEdit().getText()));
                showAlert(this.getNameFieldToEdit().getText(), this.getLastNameFiedToEdit().getText());
        //alertBoxPane.getChildren().add(alert);
    }
    @FXML
    private void cancelModification(ActionEvent event) {
        
        this.setAgeFiledToEdit("");
        this.setBlodTypeFieldToEdit("");
        this.setDiagnosticTextAreacToEdit("");
        this.setLastNameFiedToEdit("");
        this.setNameFieldToEdit("");
        this.setHistoricTextAreaToEdit("");
        
        this.ageFiledToEdit.setEditable(false);
        this.nameFieldToEdit.setEditable(false);
        this.lastNameFiedToEdit.setEditable(false);
        this.historicTextAreaToEdit.setEditable(false);
        this.diagnosticTextAreacToEdit.setEditable(false);
        this.blodTypeFieldToEdit.setEditable(false);
        
    }
    void showAlert(String name, String lastName){
         Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Your modification has been updated");
        alert.setContentText(" for patient :"+name+"  "+lastName);
        alert.setHeaderText("Update /Modification");
        alert.show();
    }
    
    
}
