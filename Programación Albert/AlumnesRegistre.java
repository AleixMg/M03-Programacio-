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

    //Farem un metodes per gestionar les materies afegir/eliminar materia.
    //<editor-fold defaultstate="collapsed" desc="Metode afegir materia">
    public void NovaMateria(String materia) {      
        this.materia.add(materia);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metode borrar la materia">
    public void BorrarMateria(String materia) {
        this.materia.remove(materia);
    }
    //</editor-fold>

    //Retorna en cadena amb salts de linia l'informació del alumne.
    //<editor-fold defaultstate="collapsed" desc="Mostrar dades alumne">
    public String toString() {         
        return "\n DNI de l'alumne: " + DNI_alumne + "\n" + " Nom: " + nom + "\n" + " Cognom: " + cognom + "\n" + " Edat: " + edat +"\n"+ " Materies: " + materia;
    }
    //</editor-fold>
}

//Declararem les variables d'instància de la classe RegistreAlumnes
class RegistrarAlumnes {         
    private HashMap<String, Alumne> alumnes;
     
    //Farem un constructor per inicialitzar el HashMap.
    //<editor-fold defaultstate="collapsed" desc="Constructor HashMap">
    public RegistrarAlumnes() {           
        alumnes = new HashMap<>();
    }
    
    //</editor-fold>
    /Farem un altre metode que serveixi per afegir un nou alumne al registre.
    //<editor-fold defaultstate="collapsed" desc="Metode afegir nou alumne">
    public void AfegirAlumne(String DNI_alumne,String nom, String cognom, int edat) {              
        Alumne noualumne = new Alumne(DNI_alumne, nom, cognom, edat);
        alumnes.put(noualumne.getNom(), noualumne);
    }
    //</editor-fold>

    //Farem un nou metode per poder afegir una materia a un alumne triant-lo amb el seu nom.
    //<editor-fold defaultstate="collapsed" desc="Metode afegir materia">
    public void AfegirMateriaAlumne(String NomAlumne, String materia) {           
        Alumne alumne = alumnes.get(NomAlumne);
        //si alumne no te valor null, és a dir hi  ha un registre, afegira la materia  
        if (alumne != null) {
            alumne.NovaMateria(materia);
        }
    }

    
    

