
package javaapplication13;

public class PatientdiagnosticLink {
    private int id_patient;
    private int id_diagnostic ;
    public PatientdiagnosticLink(int id_patient,int id_diagnostic){
        this.id_diagnostic=id_diagnostic;
        this.id_patient= id_patient;
    }
    public int getId_patient() {
        return id_patient;
    }

    public int getId_diagnostic() {
        return id_diagnostic;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public void setId_diagnostic(int id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
    }
   
}
