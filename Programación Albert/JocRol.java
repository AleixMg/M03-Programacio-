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
    //Fem un metode per poder afegir personatges manualment
    //<editor-fold defaultstate="collapsed" desc="Metode afegir personatges manualent">
    public void agregarPersonajeManualmente() {
        System.out.print("Nom del personatge: ");
        String nom = scanner.nextLine();
        System.out.print("Nivels del personatge: ");
        int nivell = scanner.nextInt();
        System.out.print("Punts de vida del personatge: ");
        int puntsVida = scanner.nextInt();
        System.out.print("Punts de mana del personatge: ");
        int puntsMana = scanner.nextInt();
        System.out.print("Tipus d'arma del personatge: ");
        String arma = scanner.next();
        System.out.print("Tipus d'armadura del personatge: ");
        String armadura = scanner.next();
        // Per limpiar el buffer
        scanner.nextLine(); 
        personajes.add(new Personaje(nom,nivell,puntsVida,puntsMana,arma,armadura));
        System.out.println("Personatge afegit correctamente.");
    }
    //</editor-fold>
 
    //Fem un metode per mostrar els personatges que hi ha 
    //<editor-fold defaultstate="collapsed" desc="Metode mostrar personatges">
    public void mostrarPersonajes() {
        System.out.println("\nLista de personajes:");
        for (Personaje personatge : personajes) {
            System.out.println("Nom: " + personatge.getNom() + "\tNivell: " + personatge.getNivel() +
                    "\tPuntos de vida: " + personatge.getPuntsVida() + "\tPuntos de mana: " + personatge.getPuntsMana()+ 
                    "\tTipus arma: " + personatge.getArma()+ "\tTipus armadura: " + personatge.getArmadura());
        }
    }
    //</editor-fold>
 
    //Fem un metode per els personatges
    //<editor-fold defaultstate="collapsed" desc="Metode per modificar personatges">
    public void modificarPersonaje() {
        System.out.print("Posa el nom del personatge que vulgui modificar: ");
        String nombre = scanner.nextLine();
        //Amb el for recorrem tots el atributs del personatge
        for (Personaje personaje : personajes) {
            if (personaje.getNom().equalsIgnoreCase(nombre)) {
                System.out.println("Personatge identificat, posi els nous atributs:");
                //Preguntem si vol cambiar aquest parametre o no
                System.out.println("\nVols posar-li un nou nom?(0 per si / 1 per no):");
                int nouNomconf = scanner.nextInt();
                if (nouNomconf == 0){
                    System.out.print("Nou nom: ");               
                    String nouNom = scanner.next();
                    personaje.setNom(nouNom);
                }else{
                    System.out.print("El nom es queda igual ");
                }
                //Preguntem si vol cambiar aquest parametre o no
                System.out.println("\nVols posar-li un nou nivell?(0 per si / 1 per no):");
                int nouNivellconf = scanner.nextInt();
                if (nouNivellconf == 0){
                    System.out.print("\nNou nivell: ");
                    int nouNivell = scanner.nextInt();
                    personaje.setNivell(nouNivell);
                }else{
                   System.out.print("El nivell es queda igual ");
                }  
                //Preguntem si vol cambiar aquest parametre o no
                System.out.println("\nVols posar-li nous punts de vida?(0 per si / 1 per no):");
                int nouVidaconf = scanner.nextInt();
                if (nouVidaconf == 0){
                    System.out.print("\nNous punts de Vida: ");
                    int nousPuntsVida = scanner.nextInt();
                    personaje.setPuntsVida(nousPuntsVida);
                }else{
                   System.out.print("Els punts de vida es queden igual ");
                }  
                //Preguntem si vol cambiar aquest parametre o no
                System.out.println("\nVols posar-li nous punts de mana?(0 per si / 1 per no):");
                int nouManaconf = scanner.nextInt();
                if (nouManaconf == 0){
                    System.out.print("\nNous punts de mana: ");
                    int nousPuntsMana = scanner.nextInt();
                    personaje.setPuntsMana(nousPuntsMana);
                }else{
                   System.out.print("Els punts de mana es queden igual ");
                }
                //Preguntem si vol cambiar aquest parametre o no
                System.out.println("\nVols posar-li un nou tipus d'arma?(0 per si / 1 per no):");
                int nouArmaconf = scanner.nextInt();
                if (nouArmaconf == 0){
                    System.out.print("\nNova Arma: ");
                    String novaArma = scanner.next();
                    personaje.setArma(novaArma);
                }else{
                   System.out.print("El tipus d'arma es queda igual ");
                }            
                //Preguntem si vol cambiar aquest parametre o no
                System.out.println("\nVols posar-li nou tipus d'armadura?(0 per si / 1 per no):");
                int nouArmaduraconf = scanner.nextInt();
                if (nouArmaduraconf == 0){
                    System.out.print("\nNova  Armadura: ");
                    String novaArmadura = scanner.next();
                    personaje.setArmadura(novaArmadura);
                }else{
                   System.out.print("El tipus d'arma es queda igual ");
                } 
                // Per limpiar el buffer
                scanner.nextLine(); 
                System.out.println("Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println("Personatge no trobat.");
    }
    //</editor-fold>

}

//Posem per ultim el main(el meu cas JocRol) amb els misatges del menu
public class JocRol {
    //Declarem aquesta variable per sortit del while
    private static int surt;
    private static final String MSG_1 = "\n******************Joc de ROl Terra d'or***********************";
    private static final String MSG_6 = "******************Joc de ROl Terra d'or***********************";
    private static final String MSG_2 = "1.Afegir un personatge nou";
    private static final String MSG_3 = "2.Mostrar els pesonatges";
    private static final String MSG_4 = "3.Modificar un personatge";
    private static final String MSG_5 = "4.Sortir";
    private static final String MSG_7 = "Selecciona l'opcio que vulguis:";
    private static final String MSG_8 = "Gracies per jugar a Terra d'or :) ";
    private static final String MSG_9 = "Vols tornar al menú o tanquem el programa?(0 per conitunar / 1 per tancar): ";
    
    public static void main(String[] args) {
        //creem una instancia de la classe GestorAventuras 
        GestorAventuras gestor = new GestorAventuras();
        // També creem una altre instancia de l'objecte scaner per a que l'usuari posi les seves opcions
        Scanner sc = new Scanner(System.in);
        //Fem el do while per a que sempre mostri el menu menys quan l'usuari posi l'opcio de sortit
        do {
            System.out.println(MSG_1);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.print(MSG_7);
            //La variable per al switch case 
            int opcion = sc.nextInt();
            // Per limpiar el buffer
            sc.nextLine(); 
            //Amb el switch case triarem les opcion
            switch (opcion) {
                case 1 ->{ 
                    gestor.agregarPersonajeManualmente();
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_9);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_8);   
                        surt = 4;   
                    }else {
                        surt=0;
                    }
                }
                case 2 -> {
                    gestor.mostrarPersonajes();
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_9);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_8);   
                        surt = 4;   
                    }else {
                        surt=0;
                    }
                }
                case 3 -> {
                    gestor.modificarPersonaje();
                    //Li preguntem al usuari si vol tancar el programa o continuar 
                    System.out.print(MSG_9);
                    int continuar = sc.nextInt();
                    if (continuar == 1 ){
                        System.out.println(MSG_8);   
                        surt = 4;   
                    }else {
                        surt=0;
                    }
                }
                case 4 -> {
                    surt = 4;
                    System.out.println(MSG_8);
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }while(surt != 4);
    }
}

