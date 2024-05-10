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
    //</editor-fold>
    
    //Farem un nou metode per poder borrar una materia a un alumne triant-lo amb els seu nom.
    //<editor-fold defaultstate="collapsed" desc="Metode eliminar materia">
    public void EliminarMateriaAlumne(String NomAlumne, String materia) {
        Alumne alumne = alumnes.get(NomAlumne);
        //si alumne no te valor null, és a dir hi  ha un registre, eliminara  la materia 
        if (alumne != null) {
            alumne.BorrarMateria(materia);
        }
    }
    //</editor-fold>
    
    //Fem un metode  per mostrar les materies dels alumnes
    //<editor-fold defaultstate="collapsed" desc="Metode mostrar materia alumne">
    public void mostrarMateria(String NomAlumne) {
        Alumne alumne = alumnes.get(NomAlumne);
        //si alumne no te valor null, és a dir hi  ha un registre, mostrara la materia  amb la resta de dades
        if (alumne != null) {
            System.out.println("Materies de l'alumne " + alumne.getDNI_alumne()+ " "+ alumne.getNom() + " " + alumne.getCognom() + ":");
            System.out.println(alumne.getMateria());
        }
    }
    //</editor-fold>
    
    //Tenim un altre metode per mostrar la informació de cada alumne registrat
    //<editor-fold defaultstate="collapsed" desc="Metode mostrar alumnes registrats">
    public void MostrarAlumnes() {                       
        System.out.println("\n Tots els alumnes registrats:");
        for (Alumne alumne : alumnes.values()) {
            System.out.println(alumne);
        }
    }
    //</editor-fold>
}


//Definim les constants per mostrar els missatges del menu,
public class AlumnesRegistre {                         
    private static final String MSG_1 = "Tria una de les diferents opcions:";
    private static final String MSG_2 = "1.Registrar un alumne nou";
    private static final String MSG_3 = "2.Afegir una nova materia a un alumne previament registrat";
    private static final String MSG_4 = "3.Eliminar matèria d'un alumne previament registrat";
    private static final String MSG_5 = "4.Mostrar tots els alumnes registrats"; 
    private static final String MSG_6 = "5.Mostrar les materies d'un alumne previament registrat";
    private static final String MSG_7 = "6.Surtir del programa";
    private static final String MSG_8 = "Selecciona l'opcio que vulguis:";
    private static final String MSG_9 = "Gracies per utilitzar el programa, tingui un bon dia :) ";
    private static final String MSG_10 = "Introdueix el nom de l'alumne:";
    private static final String MSG_11 = "\n*****************************************";
    private static final String MSG_12 = "*****************************************";
     private static final String MSG_13 = "Vols tornar al menú o tanquem el programa?(0 per conitunar / 1 per tancar): ";
    //L'utilitzarem al final per fer un bucle amb while i poder sortir quan es posi l'opció 6
    private static int opcions;
    
    
    public static void main(String[] args) {
        //creem una instancia de la classe RegistrarAlumnes 
        RegistrarAlumnes registre = new RegistrarAlumnes();
        // També creem una altre instancia de l'objecte scaner per a que l'usuari posi les seves opcions
        Scanner sc = new Scanner(System.in);
        
        //fem un do while que si surt que escogim la opcio 6 canvia la variable i finalitza el programa.
        do{
            System.out.println(MSG_11);
            System.out.println(MSG_1);
            System.out.println(MSG_12);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.println(MSG_7);
            System.out.println(MSG_8);
        
            int opcio = sc.nextInt();
            sc.nextLine();
            //Amb el switch case triarem les opcions
            switch (opcio) {                         
                case 1 -> {
                    System.out.print("DNI: ");
                    String numero_DNI = sc.nextLine();
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Cognom: ");
                    String cognom = sc.nextLine();
                    System.out.print("Edat: ");
                    int edat = sc.nextInt();
                    registre.AfegirAlumne(numero_DNI, nom, cognom, edat);
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_13);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_9);   
                        opcions = 6;   
                    }else {
                        opcions=0;
                    }
                }
                case 2 -> {
                    System.out.print(MSG_10);
                    String NomAlumne = sc.nextLine();
                    System.out.print("Intrdodueix la nova materia: ");
                    String materiaNova = sc.nextLine();
                    registre.AfegirMateriaAlumne(NomAlumne, materiaNova);
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_13);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_9);   
                        opcions = 6;   
                    }else {
                        opcions=0;
                    }
                }
                case 3 -> {
                    System.out.print(MSG_10);
                    String NomAlumne = sc.nextLine();
                    sc.nextLine(); // Netegem el buffer
                    System.out.print("Introdueix la materia que vols eliminar: ");
                    String materiaEliminada = sc.nextLine();
                    registre.EliminarMateriaAlumne(NomAlumne, materiaEliminada);
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_13);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_9);   
                        opcions = 6;   
                    }else {
                        opcions=0;
                    }
                }
                case 4 -> {
                    registre.MostrarAlumnes();
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_13);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_9);   
                        opcions = 6;   
                    }else {
                        opcions=0;
                    }
                }
                case 5 -> {
                    System.out.print(MSG_10);
                    String NomAlumne = sc.nextLine();
                    registre.mostrarMateria(NomAlumne); 
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_13);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_9);   
                        opcions = 6;   
                    }else {
                        opcions=0;
                    }
                }
                case 6 -> {
                    System.out.println(MSG_9);   
                    opcions = 6;
                }
            }
            
        }while(opcions != 6);
    }
}
    
    

