/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mon pc
 */
public class AddconsultationController implements Initializable {

    @FXML
    private TextField dateConsultation;
    @FXML
    private TextField namePatientField;
    @FXML
    private TextField lastNamePatientField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField bloodField;
    @FXML
    private JFXTextArea diagField;
    @FXML
    private JFXTextArea historyField;
    Patient patient;
    Consult consult; 
    Diagnostic diagnistic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterInfoPatient(ActionEvent event) {
        
        try {
            String namePatient = namePatientField.getText();
            String prenomPatien= lastNamePatientField.getText();
            int agePatient = Integer.parseInt(ageField.getText());
            String groupeSanguin= bloodField.getText();
            String observation= diagField.getText();
            String diagnostic= diagField.getText(); 
            String history = historyField.getText();
            System.out.println("-"+namePatient+"->"+prenomPatien+"-->"
                    +agePatient+"--->"+groupeSanguin+"---->"+observation+"---->>>>"+history+"");
            
            patient = new Patient(namePatient, prenomPatien, groupeSanguin, agePatient,history);
            diagnistic=new Diagnostic(diagnostic);//diagnostic 
            consult= new Consult(observation);//observation
           
            
            ConnectionDBTools.insertConsultaion(consult);//add new consultation
            int lastConsultID= ConnectionDBTools.getLastConsultID();//getLastID of consultation
            System.out.println("----------->>>>>>"+lastConsultID);
            ConnectionDBTools.insertIntoDiagnostic(diagnistic);//add new diagnostique
            ConnectionDBTools.InsertDataIntoPatient(patient,lastConsultID);//add new patient
            //makes relation with patient and consult and diagnostique
           int lastPatientID= ConnectionDBTools.getLastPatientID();
           int lastDiagnosticID= ConnectionDBTools.getlastDiagnostic(); 
           System.out.println("--->->"+lastConsultID+"--->>>"+lastPatientID+"***"+lastDiagnosticID);
           ConnectionDBTools.insertInPatientDiagnosticRelation(lastPatientID, lastDiagnosticID);
           ConnectionDBTools.insertConsultDiagnosticRelation(lastConsultID, lastDiagnosticID);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddconsultationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddconsultationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
