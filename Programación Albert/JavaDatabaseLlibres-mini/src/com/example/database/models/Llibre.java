package com.example.database.models;

/**
 *
 * @author aleix
 */
public class Llibre {
    //els atributs de la classe llibre
    private int id;
    private String titol,autor;
    private int anyPublicacio;
    
    //el constructor de la classe llibre per instanciar els atributs
    public Llibre(int id, String titol, String autor, int anyPublicacio) {
        this.id = id;
        this.titol = titol;
        this.autor = autor;
        this.anyPublicacio = anyPublicacio;
        
    }

    //Farem uns metodes d'accés a les varibles dels llibres amb els getters i per afigir mes endavant l'informació els setters.
    //<editor-fold defaultstate="collapsed" desc="Getters i Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(int anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutorId(String autor) {
        this.autor = autor;
    }
    //</editor-fold>

    //Fem un toString per convertir la informació en una cade de text, ho seprearem amb comes
    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Llibre {id=" + id + ", titol=" + titol + ", anyPublicacio=" + anyPublicacio + ", autor=" + autor + "}";
    }
    //</editor-fold>
}
