package alumnesregistre;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Alumne {   
    
    // Anem a declarar cada variable de l'alumne.
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private String DNI_alumne;    
    private String nom,cognom;
    //Creem un array per guardar les materies que vulgui afegir l'usuari
    private ArrayList<String> materia;
    private int edat;
    //</editor-fold>

    //Fem un constructor de la classe i inicialitzem les varibles d'instacia i l'array per a la llista de materies.
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Alumne(String DNI_alumne ,String nom, String cognom, int edat) {          
        //el id de l'alumne s'hi incrementara cada cop que sa'fegeixi un 
        this.DNI_alumne = DNI_alumne;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.materia = new ArrayList<>();
     }
     //</editor-fold>
    
    //Farem uns metodes d'accés a les varibles de l'alumne amb els getters.
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getDNI_alumne() {       
        return this.DNI_alumne;
    }

    public String getNom() {
        return this.nom;
    }

    public String getCognom() {
        return this.cognom;
    }

    public int getEdat() {
        return this.edat;
    }

    public ArrayList<String> getMateria() {
        return this.materia;
    }
    //</editor-fold>
    

