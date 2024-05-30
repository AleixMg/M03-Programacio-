package com.example.database.models;

/**
 *
 * @author aleix
 */
public class Llibre {
    //els atributs de la classe llibre
    private int id;
    private String titol,anyPublicacio;
    private int autorId;
    
    //el constructor de la classe llibre per instanciar els atributs
    public Llibre(int id, String titol, String anyPublicacio, int autorId) {
        this.id = id;
        this.titol = titol;
        this.anyPublicacio = anyPublicacio;
        this.autorId = autorId;
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

    public String getAnyPublicacio() {
        return anyPublicacio;
    }

    public void setAnyPublicacio(String anyPublicacio) {
        this.anyPublicacio = anyPublicacio;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }
    //</editor-fold>

    //Fem un toString per convertir la informació en una cade de text, ho seprearem amb comes
    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Llibre {id=" + id + ", titol=" + titol + ", anyPublicacio=" + anyPublicacio + ", autorId=" + autorId + "}";
    }
    //</editor-fold>
}
