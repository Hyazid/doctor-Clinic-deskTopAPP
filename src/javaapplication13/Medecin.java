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
public class Medecin {
    private String nom_medecin ;
    private String pre_medecin;
    private String speciality ;
    private String password;
    private String user;
    
    
    
    
    /*
    *getter an setters 
    *
    */
    public String getNom (){
        return nom_medecin;
    }
    public String getPrenom (){
        return pre_medecin; 
    } 
    public String getSpeciality (){
        return speciality;
    }
    public String getPassword(){
        return password;
    }
    public String getUser(){
        return user; 
    }
    public void setNom(String nom ){
        this.nom_medecin=nom;
    }
    public void setPrenom (String prenom ){
        this.pre_medecin= prenom;
    }
    public void setSpeciality(String speciality){
        this.speciality= speciality; 
    }
    public void setPassword(String password){
        this.password= password;
    }
    public void setUser(String user){
        this.user=user; 
    }
    
}
