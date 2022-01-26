/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class EditRDVController implements Initializable {
    @FXML
    private TextField IDRDV;
    @FXML
    private TextField searchRDVName;
    @FXML
    private TextField searchRDVLastName;
    @FXML
    private TextField patientNameToEDitField;
    @FXML
    private TextField patientLastNameFieldEdit;
    @FXML
    private TextField agePatientField;
    @FXML
    private JFXTextArea motifRDVToEditField;
    @FXML
    private DatePicker dateRDvToEdit;

    public TextField getIDRDV() {
        return IDRDV;
    }

    public void setIDRDV(TextField IDRDV) {
        this.IDRDV = IDRDV;
    }

    public TextField getSearchRDVName() {
        return searchRDVName;
    }

    public void setSearchRDVName(TextField searchRDVName) {
        this.searchRDVName = searchRDVName;
    }

    public TextField getSearchRDVLastName() {
        return searchRDVLastName;
    }

    public void setSearchRDVLastName(TextField searchRDVLastName) {
        this.searchRDVLastName = searchRDVLastName;
    }

    public TextField getPatientNameToEDitField() {
        return patientNameToEDitField;
    }

    public void setPatientNameToEDitField(TextField patientNameToEDitField) {
        this.patientNameToEDitField = patientNameToEDitField;
    }

    public TextField getPatientLastNameFieldEdit() {
        return patientLastNameFieldEdit;
    }

    public void setPatientLastNameFieldEdit(TextField patientLastNameFieldEdit) {
        this.patientLastNameFieldEdit = patientLastNameFieldEdit;
    }

    public TextField getAgePatientField() {
        return agePatientField;
    }

    public void setAgePatientField(TextField agePatientField) {
        this.agePatientField = agePatientField;
    }

    public JFXTextArea getMotifRDVToEditField() {
        return motifRDVToEditField;
    }

    public void setMotifRDVToEditField(JFXTextArea motifRDVToEditField) {
        this.motifRDVToEditField = motifRDVToEditField;
    }

    public DatePicker getDateRDvToEdit() {
        return dateRDvToEdit;
    }

    public void setDateRDvToEdit(DatePicker dateRDvToEdit) {
        this.dateRDvToEdit = dateRDvToEdit;
    }

    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveEditRDV(ActionEvent event) {
   
    }

    @FXML
    private void cancelEditRDV(ActionEvent event) {
    }

    @FXML
    private void searchRDV(ActionEvent event) {
           HashMap map=  ConnectionDBTools.getRDVToEdit(Integer.parseInt(getIDRDV().getText()), getSearchRDVName().getText(), getSearchRDVLastName().getText());
      System.out.println(" edit rdV");
    }
    
}
