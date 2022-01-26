
package javaapplication13;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class EditConsultController implements Initializable {

    @FXML
    private Pane modificationPane;

    public TextField getNameFieldToSearch() {
        return nameFieldToSearch;
    }

    public void setNameFieldToSearch(TextField nameFieldToSearch) {
        this.nameFieldToSearch = nameFieldToSearch;
    }

    public TextField getLastNameFieldToSearch() {
        return lastNameFieldToSearch;
    }

    public void setLastNameFieldToSearch(TextField lastNameFieldToSearch) {
        this.lastNameFieldToSearch = lastNameFieldToSearch;
    }
    @FXML
    private TextField nameFieldToSearch;
    @FXML
    private TextField lastNameFieldToSearch;
    HashMap map;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void editForm(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            
            //Parent fxml= FXMLLoader.load(getClass().getResource("editForm"));
             FXMLLoader loader= new FXMLLoader(getClass().getResource("editForm.fxml")); 
             Parent root =(Parent)loader.load();
            modificationPane.getChildren().removeAll();
            EditFormController efc= loader.getController();
            efc.setNameFieldToEdit(nameFieldToSearch.getText());
            efc.setLastNameFiedToEdit(lastNameFieldToSearch.getText());
            //call database and get data and put it in each field 
            String nameField=nameFieldToSearch.getText(); 
            String lastNameField= lastNameFieldToSearch.getText(); 
            // call the methode with return
            map=ConnectionDBTools.getpatientToModification(nameField, lastNameField);
            
            System.out.println(map);
            // fill the rest of the field 
            efc.setAgeFiledToEdit((String) map.get("age"));
            efc.setBlodTypeFieldToEdit((String) map.get("blood"));
            efc.setHistoricTextAreaToEdit((String) map.get("historic"));
            efc.setDiagnosticTextAreacToEdit((String)map.get("historic"));
            
            
            modificationPane.getChildren ().addAll(root);
        } catch (IOException ex) {
            Logger.getLogger(EditConsultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
      
}
