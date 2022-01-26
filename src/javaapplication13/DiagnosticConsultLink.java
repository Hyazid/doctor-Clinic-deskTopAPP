
package javaapplication13;


public class DiagnosticConsultLink {
     private int id_diagnostic;
    private int id_conult;

    public int getId_diagnostic() {
        return id_diagnostic;
    }

    public int getId_conult() {
        return id_conult;
    }

    public void setId_diagnostic(int id_diagnostic) {
        this.id_diagnostic = id_diagnostic;
    }

    public void setId_conult(int id_conult) {
        this.id_conult = id_conult;
    }
    
   
    
    public DiagnosticConsultLink(int id_diagnostic, int id_conult){
        this.id_diagnostic=id_diagnostic;
        this.id_conult=id_conult;
    }
}
