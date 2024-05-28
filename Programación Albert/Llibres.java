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

// Fem les tres classes específiques per a cada gènere de llibres
class Novela extends Llibre {
    public Novela(String titol, String autor, int any) {
        super(titol, autor, any);
    }
}

class CienciaFiccio extends Llibre {
    public CienciaFiccio(String titol, String autor, int any) {
        super(titol, autor, any);
    }
}

class Poesia extends Llibre {
    public Poesia(String titol, String autor, int any) {
        super(titol, autor, any);
    }
}

// Fem una altre classe genèrica per a gestionar les llistes de llibres, on farem els metodes per gestionar les llistes
class LlistaLlibres<T extends Llibre> {
    private HashMap<String, T> llibres;

    public LlistaLlibres() {
        llibres = new HashMap<>();
    }

    //metode per afegir un llibre
    public void afegirLlibre(T llibre) {
        llibres.put(llibre.getTitol(), llibre);
    }
    
    //metode per afegir un llibre
    public void eliminarLlibre(String titol) {
        llibres.remove(titol);
    }
    
    //metode per buscar un llibre
    public T buscarLlibre(String titol) {
        return llibres.get(titol);
    }
    
    //metode per mostrar tots els llibres
    public void mostrarLlibres() {
        for (T llibre : llibres.values()) {
            System.out.println(llibre);
        }
    }
}

