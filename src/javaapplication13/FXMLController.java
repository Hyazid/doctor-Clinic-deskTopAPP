
package javaapplication13;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet; 

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.bson.Document; 
import org.json.JSONObject;



public class FXMLController implements Initializable {

    @FXML
    private Pane pane2;
    @FXML
    private Pane pane;
    @FXML
    private Button Login;
    @FXML
    public  TextField userField;
    @FXML
    public PasswordField passField;
    @FXML
    Label checking;
    
    
    private Stage stage;
    private Scene scene; 
    private Parent root; 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    @FXML
    private void handleLogin(ActionEvent event) throws IOException  {
        System.out.print("button clicked");
        String user = userField.getText();
        String pass = passField.getText(); 
        System.out.println("-"+user);
        System.out.println("-"+pass);
        
        
        //connection(user, pass, checking);
        if(connection(user, pass, checking)){
            switchToDashBoard(event); 
        }
        else{
            System.out.println("user not found");
        }
          
    }
    public static Boolean connection (String userName, String passWord, Label checking) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            System.out.println("Connected to the database successfully");
            //System.out.print(con.getClass().getSimpleName());
            Statement stm = con.createStatement(); 
            ResultSet res = stm.executeQuery
        ("select user, password from medecin where user='"+userName+"'and password='"+passWord+"'"); 
          
            while(res.next()){
                String user= res.getNString("user");
                String pass= res.getString("password"); 
                System.out.println("-->"+user);
                System.out.println("-->"+pass);
                checking.setText("Connecting ...");
                return true; 
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      return false;
      
        
    }
    public void switchToDashBoard(ActionEvent event) throws IOException{
       FXMLLoader loader= new FXMLLoader(getClass().getResource("dashboard.fxml")); 
       Parent root =(Parent)loader.load();
       DashboardController dc = loader.getController(); 
       dc.setDocLable(userField.getText());
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
       
       
       // stage= (Stage)((Node)event.getSource()).getScene().getWindow(); 
        //scene= new Scene (root); 
        //stage.setScene(scene);
        //stage.show();
        
    }
    
    

    
}
