package com.example.database.models;

/**
 *
 * @author aleix
 */
public class Autor {
    //els atributs de la classe autor
    private int id;
    private String nom,cognom;

    //el constructor de la classe autor per instanciar els atributs
    public Autor(int id, String nom, String cognom) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
    }
    
    //Farem uns metodes d'accés a les varibles del autor amb els getters i per afigir mes endavant l'informació els setters.
    //<editor-fold defaultstate="collapsed" desc="Getters i Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    //</editor-fold>
    

    //Fem un toString per convertir la informació en una cade de text, ho seprearem amb comes
    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "Autor {id=" + id + ", nom=" + nom + ", cognom=" + cognom + "}";
    }
    //</editor-fold>
}
