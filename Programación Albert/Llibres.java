package llibres;
import java.util.HashMap;
import java.util.Scanner;

// Classe base per a Llibre
class Llibre {
    
    // Anem a declarar cada variable que tindra el llibre.
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private String titol, autor;
    private int any;
    //</editor-fold>

    //Fem un constructor de la classe i inicialitzem les varibles d'instacia.
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Llibre(String titol, String autor, int any) {
        this.titol = titol;
        this.autor = autor;
        this.any = any;
    }
    //</editor-fold>
