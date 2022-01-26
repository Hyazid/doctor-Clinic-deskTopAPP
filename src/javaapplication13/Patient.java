/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author Mon pc
 */
public class Patient {

    

   
   
    private String nom_patient;
    private String prenom_patient;
    private String group_Sanguin; 
    private int age; 

 
    private String historic; 
    public Patient( String nom_patient,String prenom_patient,
            String group_Sanguin,int age, String historic )
    {
 
        this.nom_patient=nom_patient;
        this.prenom_patient=prenom_patient; 
        this.group_Sanguin=group_Sanguin;
        this.age=age; 
        this.historic=historic; 
     
    }
   

    public String getNom_patient() {
        return nom_patient;
    }

    public String getPrenom_patient() {
        return prenom_patient;
    }

    public String getGroup_Sanguin() {
        return group_Sanguin;
    }

    public int getAge() {
        return age;
    }
    public String getEntecedant() {
        return historic;
    }

    

    public void setNom_patient(String nom_patient) {
        this.nom_patient = nom_patient;
    }

    public void setPrenom_patient(String prenom_patient) {
        this.prenom_patient = prenom_patient;
    }

    public void setGroup_Sanguin(String group_Sanguin) {
        this.group_Sanguin = group_Sanguin;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEntecedant(String historic) {
        this.historic = historic;
    }
    
     
    
    
}
