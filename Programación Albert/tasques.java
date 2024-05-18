//Utilitzare una estructura similiar a la practica que vaig entregar de AlumnesRegistre i al Joc de Rol
package tasques;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tasca {
    // Anem a declarar cada variable del personatge.
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private String titol,descripcio,estat;
    private LocalDate data;
    //</editor-fold>

    /Fem un constructor de la classe i inicialitzem les varibles d'instacia.
    //<editor-fold defaultstate="collapsed" desc="Constructor Tasca">
    public Tasca(String titol, String descripcio, LocalDate data, String estat) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.data = data;
        this.estat = estat;
    }
    //</editor-fold>
    
    //Farem uns metodes d'accés a les varibles de la tasca amb els getters i per afigir mes endavant l'informació els setters.
    //<editor-fold defaultstate="collapsed" desc="Getters i Setters">
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    //Fem un toString per convertir la informació en una cade de text, ho seprearem amb comes
    @Override
    public String toString() {
        return titol + "," + descripcio + "," + data + "," + estat;
    }
    //</editor-fold>
}
