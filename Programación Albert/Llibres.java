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
    
    //Farem uns metodes d'accés a les varibles de l'alumne amb els getters.
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getAny() {
        return any;
    }
    //</editor-fold>

    //Fem un toString per convertir la informació en una cade de text, ho seprearem amb tabulacions
    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Títol: " + titol + "\tAutor: " + autor + "\tAny: " + any;
    }
    //</editor-fold>
}
