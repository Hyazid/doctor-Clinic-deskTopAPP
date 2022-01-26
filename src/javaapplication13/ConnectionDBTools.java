
package javaapplication13;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
public class ConnectionDBTools {
    
   
    public static Boolean connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true; 
    }
    public static Boolean InsertDataIntoPatient(Patient patient, int lastConsultID){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            
            //create statement and excute 
            Statement stm = con.createStatement(); 
            String sql;
            sql = " INSERT INTO medecin.patient(name_patient,lastname_patient, blood,age,id_consult,historic) "
                    + "VALUES('"+patient.getNom_patient()+"','"+patient.getPrenom_patient()+"','"+patient.getGroup_Sanguin()+"',"+patient.getAge()+","+lastConsultID+",'"+patient.getEntecedant()+"')";
            stm.executeUpdate(sql); 
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true; 
    }
    public static Boolean insertConsultaion (Consult consult){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement(); 
            String sql="INSERT INTO medecin.consult(date_of_consult,observation)"
                    + "VALUES(NOW(),'"+consult.getObservation()+"')";
              stm.executeUpdate(sql); 
            con.close();
            
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
    }
    static int getLastConsultID() throws ClassNotFoundException, SQLException{
         int ID= 0;
        
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement(); 
            String sql= "SELECT max(id_conult) FROM medecin.consult"; 
            ResultSet rst= stm.executeQuery(sql); 
            
            while(rst.next()){
                 System.out.println("-->"+rst.getInt("max(id_conult)"));
                 ID=rst.getInt("max(id_conult)");
            }
            return ID; 
        
           
     }
    static void insertIntoDiagnostic(Diagnostic diagnistic){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql= "INSERT INTO medecin.diagnostic(resume_diagnostic)VALUES('"+diagnistic.getResumeDiagnostic()+"')";
            stm.executeUpdate(sql); 
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    static int getLastPatientID() throws ClassNotFoundException, SQLException{
        int ID=0; 
        Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql="SELECT max(id_patient)from medecin.patient";
            ResultSet rst= stm.executeQuery(sql);
            while(rst.next()){
                 System.out.println("-->"+rst.getInt("max(id_patient)"));
                 ID=rst.getInt("max(id_patient)");
            }
            return ID;
            
        
    }
    static int getlastDiagnostic() throws ClassNotFoundException, SQLException{
        int ID =0; 
         Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql="SELECT max(id_diagnostic)from medecin.diagnostic";
            ResultSet rst= stm.executeQuery(sql);
             while(rst.next()){
                 System.out.println("-->"+rst.getInt("max(id_diagnostic)"));
                 ID=rst.getInt("max(id_diagnostic)");
            }
        return ID; 
    }
    static void insertInPatientDiagnosticRelation(int id_patient, int id_diagnostic){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement(); 
            String sql=
                    "INSERT INTO medecin.con_diag(id_patient, id_diagnostic,date_of_diagcon)"
                    + "VALUES('"+id_patient+"','"+id_diagnostic+"',NOW())";
            stm.executeUpdate(sql);
            stm.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void insertConsultDiagnosticRelation(int id_consult,int id_diagnostic){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql=
                    "INSERT INTO medecin.have(id_consult, id_diagnostic)VALUES"
                    + "('"+id_consult+"', '"+id_diagnostic+"')";
            stm.executeUpdate(sql);
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static HashMap getPatientDiagnosticConsult() throws ClassNotFoundException, SQLException{
        //this for general fram
        String namePatient="name_patient";
        String lastname_patien="lastname_patient";
        String blood="blood";
        String ageText= "age";
        String resume_diag= "resume_diagnostic";
        String id_consult="id_consult"; 
        String observation= "observation";
        String id_patient="id_patient";
        HashMap<String,String > result= new HashMap<String,String>(); 
        
         Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql="SELECT medecin.patient.id_patient,resume_diagnostic,name_patient,lastname_patient,age,blood,observation FROM medecin.diagnostic,medecin.consult,medecin.patient,medecin.have,medecin.con_diag\n" +
"where medecin.patient.id_patient=medecin.con_diag.id_patient and medecin.diagnostic.id_diagnostic=medecin.con_diag.id_diagnostic and medecin.diagnostic.id_diagnostic=medecin.have.id_diagnostic and medecin.consult.id_conult=medecin.have.id_consult";
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                  result.put(id_patient, res.getString("id_patient"));
                  result.put(namePatient, res.getString("name_patient"));
                  result.put(lastname_patien, res.getString("lastname_patient"));
                  result.put(ageText, res.getString("age"));
                  result.put(blood, res.getString("blood"));
                  result.put(resume_diag, res.getString("resume_diagnostic"));
                  result.put(observation, res.getString("observation"));
                  
            }
             System.out.println("Initial list of elements: "+result);
            for(Map.Entry m: result.entrySet()){
                   System.out.println(m.getKey()+" "+m.getValue());    
            }
        return result  ;
    }
    static HashMap getpatientToModification(String name , String LastName) throws ClassNotFoundException, SQLException{
        String namePatient="name_patient";
        String lastname_patien="lastname_patient";
        String blood="blood";
        String ageText= "age";
        String id_consult="id_consult"; 
        String historic= "historic";
        String id_patient="id_patient";
        HashMap <String, String>result = new HashMap<String, String>();
        
        Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql=" SELECT medecin.patient.name_patient,medecin.patient.lastname_patient,medecin.patient.age,medecin.patient.blood,medecin.patient.historic from medecin.patient\n" +
" where medecin.patient.name_patient='"+name+"'or medecin.patient.lastname_patient='"+LastName+"'";
            ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                result.put(namePatient,res.getString("name_patient"));
                result.put(lastname_patien, res.getString("lastname_patient"));
                result.put(ageText,Integer.toString(res.getInt("age")));
                result.put(blood, res.getString("blood"));
                result.put(historic, res.getString("historic"));
            }
            
            
            System.out.println("Initial list of elements: "+result);
        
        
        return result; 
    }
    static HashMap getInfoPatientToEdit(String name, String lastName) throws ClassNotFoundException, SQLException{
        HashMap<String, String> result;
        result = new HashMap<String, String>();
        String namePatient="name_patient";
        String lastname_patien="lastname_patient";
        String blood="blood";
        String ageText= "age";
        String resume_diag= "resume_diagnostic";
        String historic= "historic";
        Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String SQL= " SELECT medecin.patient.name_patient,medecin.patient.lastname_patient,medecin.patient.age,medecin.patient.blood,medecin.patient.historic, medecin.diagnostic.resume_diagnostic from medecin.patient, medecin.diagnostic, medecin.con_diag\n" +
" where medecin.patient.name_patient='one'and medecin.patient.id_patient= medecin.con_diag.id_patient and medecin.diagnostic.id_diagnostic=medecin.con_diag.id_diagnostic ";
            ResultSet res= stm.executeQuery(SQL);
            while(res.next()){
                result.put(namePatient,res.getString("name_patient"));
                result.put(lastname_patien, res.getString("lastname_patient"));
                result.put(ageText, res.getString("age"));
                result.put(blood, res.getString("blood"));
                result.put(historic, res.getString("historic"));
                result.put(resume_diag, res.getString("diagnostic"));
                
            }
            System.out.println("Initial list of elements: "+result);
        
        return result;
    }
    static void updateAfterModificationPatietInfo(String OLName,String OLDLastName, String blood ,String historic, int age ){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql = "UPDATE medecin.patient set "
                    + "medecin.patient.age='"+age+"',"
                    + "medecin.patient.blood='"+blood+"',"
                    + "medecin.patient.historic='"+historic+"'"
                    + "where medecin.patient.name_patient='"+OLName+"' and medecin.patient.lastname_patient='"+OLDLastName+"'";
            
                    stm.executeUpdate(sql);
                    con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    static void insertRDV(String date, int age, String namePatient,String lastName,String motif){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql="INSERT INTO medecin.rdv (nomPatient,prenomPatient, motifRDV,dateRDV,age) VALUES"
                    + "('"+namePatient+"','"+lastName+"', '"+motif+"','"+date+"', "+age+" )";
            stm.executeUpdate(sql);
            //return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
            //return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
            //return false; 
        }
    }
    static HashMap getRDVToEdit(int idRDV, String namePatient , String lastNamePatient){
        try {
            HashMap<String, String> result= new HashMap<>();
            String idRDVPAtient;
            idRDVPAtient = "id";
            String namePatientRDV="nomPatient";
            String lastname_patient_rdv="prenomPatient";
            String age= "age";
            String motifRdv="motifRDV";
            String dateRDV="dateRDV";
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con ;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/medecin","root","root");
            
            System.out.println("Connected to the database successfully");
            Statement stm = con.createStatement();
            String sql="SELECT * from medecin.rdv where id=5";
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                result.put(idRDVPAtient, res.getString("id"));
                result.put(namePatientRDV, res.getString("nomPatient"));
                result.put(lastname_patient_rdv, res.getString("prenomPatient"));
                result.put(age, res.getString("age"));
                result.put(motifRdv, res.getString("motifRDV"));
                result.put(dateRDV, res.getString ("dateRDV"));
            }
            System.out.println("Initial list of elements: "+result);
            
            
            
            return  result;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBTools.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

   
}   
