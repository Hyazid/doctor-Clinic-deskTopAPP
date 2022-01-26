/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class AddRDVController implements Initializable {
    
    @FXML
    private TextField namePatient;
    @FXML
    private TextField lastNamePatient;
    @FXML
    private TextField agePatient;
    @FXML
    private DatePicker dateRDV;
    @FXML
    private TextArea motifRDV;

    public TextField getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(TextField namePatient) {
        this.namePatient = namePatient;
    }

    public TextField getLastNamePatient() {
        return lastNamePatient;
    }

    public void setLastNamePatient(TextField lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public TextField getAgePatient() {
        return agePatient;
    }

    public void setAgePatient(TextField agePatient) {
        this.agePatient = agePatient;
    }

    public DatePicker getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(DatePicker dateRDV) {
        this.dateRDV = dateRDV;
    }

    public TextArea getMotifRDV() {
        return motifRDV;
    }

    public void setMotifRDV(TextArea motifRDV) {
        this.motifRDV = motifRDV;
    }

    

    //String date = dateRDV.getPromptText();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void close(ActionEvent event) {
        this.close(event);
        
    }

    private void AddNewRDV(ActionEvent event) {
        System.out.print("i am controller");
    }

    @FXML
    private void addNewRDV(ActionEvent event) {
         System.out.println("i am controller");
         String dateRDVString=dateRDV.getValue().toString();
         System.out.print(""+dateRDVString );
        
         //System.out.println(date);
         if( getLastNamePatient().equals("")&&getNamePatient().equals("")&& getAgePatient().equals("")
                 && getMotifRDV().equals("")&& getDateRDV().equals("")){
             Alert alert= new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning something went wrong");
                alert.setContentText("Warning chekck if every thing is correct");
                alert.setHeaderText("Warning insert");
                alert.show();
             
         }
         else{
                 ConnectionDBTools.insertRDV(dateRDVString,Integer.parseInt(getAgePatient().getText()),getNamePatient().getText(),getLastNamePatient().getText(),getMotifRDV().getText());
                 Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RDV inserted with success");
                alert.setContentText("RDV insert");
                alert.setHeaderText(" insert RDV succesfully");
                alert.show();
                getAgePatient().setText("");
                getNamePatient().setText("");
                getLastNamePatient().setText("");
                getMotifRDV().setText("");
                
         }
         /*if(checkInsert==false){
              Alert alert= new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning something went wrong");
                alert.setContentText("Warning chekck if every thing is correct");
                alert.setHeaderText("Warning insert");
                alert.show();
         }
         else if(checkInsert==true){
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RDV inserted with success");
                alert.setContentText("RDV insert");
                alert.setHeaderText(" insert RDV");
                alert.show();
             
             
         }*/
         
            
    }
    

    @FXML
    private void Cancel(ActionEvent event) {
    }
    
}
