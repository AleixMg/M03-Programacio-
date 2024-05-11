//Vaig comecar-ho un dia abans i el codi esta mig fet en catala i castella
package jocrol;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

 class Personaje {
         
    // Anem a declarar cada variable del personatge.
    //<editor-fold defaultstate="collapsed" desc="Atributs">
    private String nom, arma, armadura;
    private int nivell;
    private int puntsVida;
    private int puntsMana;
    //</editor-fold>
  
    //Fem un constructor de la classe i inicialitzem les varibles d'instacia.
    //<editor-fold defaultstate="collapsed" desc="Constructor Personaje">
    public Personaje(String nom, int nivell, int puntsVida, int puntsMana, String arma, String armadura) {
        this.nom = nom;
        this.nivell = nivell;
        this.puntsVida = puntsVida;
        this.puntsMana = puntsMana;
        this.arma = arma;
        this.armadura = armadura;
    }
    //</editor-fold>
    
    //Farem uns metodes d'accés a les varibles de l'alumne amb els getters i per afigir mes endavant l'informació els setters.
    //<editor-fold defaultstate="collapsed" desc="Getters i Setters">
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNivel() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public int getPuntsVida() {
        return puntsVida;
    }

    public void setPuntsVida(int puntsVida) {
        this.puntsVida = puntsVida;
    }

    public int getPuntsMana() {
        return puntsMana;
    }

    public void setPuntsMana(int puntsMana) {
        this.puntsMana = puntsMana;
    }
    
    public String getArma() {
        return this.arma;
    }
    
    public void setArma(String arma) {
        this.arma = arma;
    }
    
    public String getArmadura() {
        return this.armadura;
    }
    
    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }
    //</editor-fold>
}

//declarem la nova clase per gestionar la aventura(als personatges)
class GestorAventuras {
    //declarem una llista de personatges
    private List<Personaje> personajes;
    //declarem el Scanner per després el usuari pugui introduir les dades 
    private Scanner scanner;

    //Declarem un constructor de la classe de GestorAventuras per inicialitzar la llista de abans 
    //<editor-fold defaultstate="collapsed" desc="Truca de metodes GestorAventuras">
    public GestorAventuras() {
        this.personajes = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        //Truquem al metode per carregar l'arxiu XML que hem guardat en una carpeta que abans haviem creat dins del projecte anemadoa files on hem guardat el XML
        carregarPersonatgesPredefinits("files/personatges.xml");
    }
    //</editor-fold>
 
    //Ara creem el metode per carregar el personatges desde l'arxiu XML de la carpeta files.
    //<editor-fold defaultstate="collapsed" desc="Metode per carregar el personatges desde el XML">
    public void carregarPersonatgesPredefinits(String archivoXML) {
         try {
            //Primer necesitem crear l'objecte File utilitzant la ruta on hem guardat l'arxiu.
            File arxiuXML = new File("files/personatges.xml");
            //Després instanciem l'objecte DocumentBuilderFactory 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Continuem creant el DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(arxiuXML);
            doc.getDocumentElement().normalize();
            //Després obtenim la llista de personatges desde el XML, o dit d'una altre forma els nodes del document XML.
            NodeList LLpersonatges = doc.getElementsByTagName("personatge");
            //Continuem iterant la llista de personatges
            for (int i = 0; i < LLpersonatges.getLength(); i++) {
                Node n = LLpersonatges.item(i);
                //Hem de verificar si el node és ELEMENT_NODE
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element registre = (Element) n;
                    //Per poder afegirlos al codi extraiem els valors dels personatges amb els mateix noms que hi ha en el document XML i els guardem com a variables.
                    String nom = registre.getElementsByTagName("nom").item(0).getTextContent();
                    int nivell = Integer.parseInt(registre.getElementsByTagName("nivell").item(0).getTextContent());
                    int puntsVida = Integer.parseInt(registre.getElementsByTagName("puntsDeVida").item(0).getTextContent());
                    int puntsMana = Integer.parseInt(registre.getElementsByTagName("puntsDeMana").item(0).getTextContent());
                    String arma = registre.getElementsByTagName("arma").item(0).getTextContent();
                    String armadura = registre.getElementsByTagName("armadura").item(0).getTextContent();
                    //Per ultim amb les variables que els hem guardat els afegim a Personaje.
                    personajes.add(new Personaje(nom, nivell, puntsVida, puntsMana, arma, armadura));
                   
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //</editor-fold>
