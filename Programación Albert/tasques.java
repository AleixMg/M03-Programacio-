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
//declarem la nova clase per gestionar les Tasques(afegir tasques, modificarles, borrarles, o mostrarles)
class GestioTasques {
    //declarem una llista per les tasques
    private List<Tasca> tasques;
    //declarem el Scanner per després el usuari pugui introduir les dades 
    private Scanner scanner;

    //Declarem un constructor de la classe de GestorAventuras per inicialitzar la llista de abans 
    //<editor-fold defaultstate="collapsed" desc="Truca de metodes GestioTasques">
    public GestioTasques() {
        this.tasques = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    //</editor-fold>
    
    //Fem un metode per carregar les tasques
    //<editor-fold defaultstate="collapsed" desc="Metode càrrega de tasques">
    public void carregarTasques(String Fitxer) {
        //Amb un BufferedReader y la variable Fitxer( es la variable que utilitzarem per a que l'usuari posi el nom del fitxer que vol editar) podem llegir i carregar el fitxer 
        try (BufferedReader br = new BufferedReader(new FileReader(Fitxer))) {
            String llegirLinia;
            //Amb un while podem recorre l'arxiu amb la varibale llegirLinea
            while ((llegirLinia = br.readLine()) != null) {
                String[] camps = llegirLinia.split(",");
                //Asignem a  cada registre laa variable corresponent, utilitzem unes comes per a delimitar y afegir a les variables
                String titol = camps[0];
                String descripcio = camps[1];
                LocalDate data = LocalDate.parse(camps[2]);
                String estat = camps[3];
                //Amb un .add afegim els registres
                tasques.add(new Tasca(titol, descripcio, data, estat));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //</editor-fold>

    //Fem un metode per desar les tasques
    //<editor-fold defaultstate="collapsed" desc="Metode desar les tasques">
    public void desarTasques(String Fitxer) {
        //Abans per carregar ell fitxer hem utilitzar un BufferedReader, ara per editar-ho utilitzem un BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Fitxer))) {
            for (Tasca tasca : tasques) {
                 //Ho escriivim amb el toString les lines de text.
                bw.write(tasca.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //</editor-fold>
