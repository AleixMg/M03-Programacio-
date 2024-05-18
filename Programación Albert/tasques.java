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

    //Fem un metode per afegir les tasques
    //<editor-fold defaultstate="collapsed" desc="Metode afegir tasques">
    public void afegirTasca() {
        //Els afegim aumb un scanner
        System.out.print("Introdueixi el titol de la tasca: ");
        String titol = scanner.nextLine();
        System.out.print("Introdueixi la descripcio de la tasca: ");
        String descripcio = scanner.nextLine();
        System.out.print("Introdueixi la data de venciment (els parametres han de ser YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());
        System.out.print("Introdueixi el estat de la tasca (pendent, en curs, completada): ");
        String estat = scanner.nextLine();
        //Amb un .add afegim el nous registres
        tasques.add(new Tasca(titol, descripcio, data, estat));
        System.out.println("La tasca s'ha afegit correctament.");
    }
    //</editor-fold>

    //Fem un metode per modificar les tasques
    //<editor-fold defaultstate="collapsed" desc="Metode modificar tasques">
    public void modificarTasca() {
        System.out.print("Titol de la tasca que voleu modificar: ");
        String titol = scanner.nextLine();
        for (Tasca tasca : tasques) {
            //per a modificar ho farem primer que l'usuari posi el nom del titol de la tasca i després ho buuusquem per aquest.
            if (tasca.getTitol().equalsIgnoreCase(titol)) {
                //Preguntem abans si vol modificar aquest parametre o no
                System.out.print("Vols un nou titol? (Introdueix SI o NO): ");
                String canviTitol = scanner.nextLine();
                //si posa si es modificara, en cas de posar quasevol altre cosa el deixara igual 
                if (canviTitol.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix el nou titol: ");
                    String nouTitol = scanner.nextLine();
                    tasca.setTitol(nouTitol);
                }
                //Preguntem abans si vol modificar aquest parametre o no
                System.out.print("Vols una nova descripcio? (Introdueix SI o NO): ");
                String canviDescripcio = scanner.nextLine();
                //si posa si es modificara, en cas de posar quasevol altre cosa el deixara igual
                if (canviDescripcio.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix la nova descripcio: ");
                    String novaDescripcio = scanner.nextLine();
                    tasca.setDescripcio(novaDescripcio);
                }
                //Preguntem abans si vol modificar aquest parametre o no
                System.out.print("Vols una nova data de venciment? (Introdueix SI o NO): ");
                String canviData = scanner.nextLine();
                //si posa si es modificara, en cas de posar quasevol altre cosa el deixara igual
                if (canviData.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix la nova data de venciment (YYYY-MM-DD): ");
                    LocalDate novaDataVenciment = LocalDate.parse(scanner.nextLine());
                    tasca.setData(novaDataVenciment);
                }
                //Preguntem abans si vol modificar aquest parametre o no
                System.out.print("Vols un nou estat? (Introdueix SI o NO): ");
                String canviEstat = scanner.nextLine();
                //si posa si es modificara, en cas de posar quasevol altre cosa el deixara igual
                if (canviEstat.equalsIgnoreCase("SI")) {
                    System.out.print("Introdueix el nou estat (pendent, en curs, completada): ");
                    String nouEstat = scanner.nextLine();
                    tasca.setEstat(nouEstat);
                }
                System.out.println("La tasca s'ha modificat correctament.");
                return;
            }
        }
        System.out.println("No hi ha cap tasca amb aquest titol.");
    }
    //</editor-fold>

    //Fem un metode per eliminar les tasques
    //<editor-fold defaultstate="collapsed" desc="Metode eliminar tasques">    
    public void eliminarTasca() {
        System.out.print("Titol de la tasca a eliminar: ");
        String titol = scanner.nextLine();
        for (int x = 0; x < tasques.size(); x++) {
            //Fem com el metode de modificar les tasques , primer l'usuari posara el nom de la tasca a eliminar i amb un for ho cerca i la eliminem.
            if (tasques.get(x).getTitol().equalsIgnoreCase(titol)) {
                tasques.remove(x);
                System.out.println("La tasca s'ha eliminat correctament.");
                return;
            }
        }
        System.out.println("No hi ha cap tasca amb aquest titol.");
    }
    //</editor-fold>
    
    //Fem un metode per visualitzar les tasques
    //<editor-fold defaultstate="collapsed" desc="Metode visualitzar tasques">     
    public void visualitzarTasques() {
        //ho declarem per posar un text amb el numero de la tasca farem que sigui un valor que s'autocincrementi amb el for
        int numero = 0;
        System.out.println("Llista de les tasques:");
        for (Tasca tasca : tasques) {
            numero = numero + 1;
            System.out.println("--------------------");
            System.out.println("Tasca numero:"+ numero);
            System.out.println("--------------------");
            System.out.println("Titol: " + tasca.getTitol() + "\nDescripcio: " + tasca.getDescripcio() +
                               "\nData de venciment: " + tasca.getData() + "\nEstat: " + tasca.getEstat());
        }
    }
    //</editor-fold>
    
    //Fem un metode per sortir del programa quan l'usuari posi aquesta opcio
    //<editor-fold defaultstate="collapsed" desc="Metode sortir del programa"> 
    public void sortir() {
        scanner.close();
        System.exit(0);
    }
    //</editor-fold>
}

//Posem per ultim el main(el meu cas Tasques) amb els misatges del menu
public class Tasques {
    //Declarem aquesta variable per sortit del while
    private static String surt;
    private static final String MSG_1 = "********GESTOR DE TASQUES********";
    private static final String MSG_2 = "1. Afegir una nova tasca a abans seleccionat";
    private static final String MSG_3 = "2. Modificar una tasca del fitxer abans seleccionat";
    private static final String MSG_4 = "3. Eliminar una tasca del fitxer abans seleccionat";
    private static final String MSG_5 = "4. Visualitzar la llista de tasques del fitxer abans seleccionat";
    private static final String MSG_6 = "5. Sortir del programa per guardar el fitxer amb les tasques";
    private static final String MSG_8 = "Selecciona una opcio: ";
    private static final String MSG_9 = "Introdueix el nom del fitxer de tasques(has de posar l'extensio .txt al final del nom): ";
    private static final String MSG_10 = "NOTA!-->Si el fitxer no existeix es creara automaticament al introduir el nom, si ja existeix al introduir el nom detectara l'arxiu i es podrá modificar.";
    private static final String MSG_11 = "NOTA2!-->Unicament es guardara el fitxer amb les tasques introduides si es surt del programa amb l'opció 5";
    private static final String MSG_12 = "Error en dades posi un número no una lletra ni un altre carcater"; 
    private static final String MSG_13 = "Vols soritr del programa? (Introdueix SI o NO): ";
    private static final String MSG_14 = "Sortint del programa i guardant arxiu...Gracies per utilitzar el nostre gestor de tasques :) ";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // la variable booleana correcte es per validar que s'hi introdueixin números
        boolean correcte;
        //Declarem també la variable opcio per a que després amb el switch case pugui escollir l'usuari l'opcio que vulgui.
        int opcio = 0;
        System.out.println(MSG_10);
        System.out.println(MSG_11);
        System.out.print(MSG_9);
        //Fem que l'usuari posi el nom del fitxer que vol editar(l'usuari manualment a de posar l'extensió del fitxer)
        String Fitxer = sc.nextLine();
        //creem una instancia de la classe GestorTasques 
        GestioTasques gestor = new GestioTasques();
        File fitxer = new File(Fitxer);
        //Comprovem si el nom de fitxer que ha posat existeix, si existeix cridem al metode per carregar el fitxer
        if (fitxer.exists()) {
            gestor.carregarTasques(Fitxer);
        }

        //amb un while (true) fem que sempre entrem al bucle del while i l'unica forma de sortir del programa sigui amb l'opció 5.
        while (true) {
            System.out.println(MSG_1);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            System.out.println(MSG_1);
            //Fem un do while de forma que si l'usuari no posa un número i posa qualsevol altre carracter el programa no finalitzara fins que posi un, despres el swicth confirmara si es una acció valida  o no
            do{
            System.out.print(MSG_8);
            correcte=sc.hasNextInt();
            if(correcte){
                opcio = sc.nextInt();
            }else{
                sc.next();
                System.out.println(MSG_12);
            }
            }while(!correcte);
            sc.nextLine(); 
            
            //fem un switch case pper a que l'usuari pugui escollir una opció 
            switch (opcio) {
                case 1 -> {
                    //Cridem al metode per afegiir la tasca 
                    gestor.afegirTasca();
                    //Li preguntem al usuari si vol tancar el programa o continuar
                    System.out.print(MSG_13);
                    surt = sc.nextLine();
                    //Si posa si guardem i cridem al metode per sorit 
                    if (surt.equalsIgnoreCase("SI")) { 
                        gestor.desarTasques(Fitxer);
                        System.out.println(MSG_14);
                        gestor.sortir();   
                    }
                }
                case 2 ->{
                    //Cridem al metode per modificar la tasca 
                    gestor.modificarTasca();
                    //Li preguntem al usuari si vol tancar el programa o continuar
                    System.out.print(MSG_13);
                    surt = sc.nextLine();
                    //Si posa si guardem i cridem al metode per sorit 
                    if (surt.equalsIgnoreCase("SI")) { 
                        gestor.desarTasques(Fitxer);
                        System.out.println(MSG_14);
                        gestor.sortir();   
                    }
                }
                case 3 ->{
                    //Cridem al metode per eliminar la tasca 
                    gestor.eliminarTasca();
                    //Li preguntem al usuari si vol tancar el programa o continuar
                    System.out.print(MSG_13);
                    surt = sc.nextLine();
                    //Si posa si guardem i cridem al metode per sorit 
                    if (surt.equalsIgnoreCase("SI")) { 
                        gestor.desarTasques(Fitxer);
                        System.out.println(MSG_14);
                        gestor.sortir();   
                    }
                }
                case 4 ->{
                    //Cridem al metode per visualitzar les tasques
                    gestor.visualitzarTasques();
                    //Li preguntem al usuari si vol tancar el programa o continuar
                    System.out.print(MSG_13);
                    surt = sc.nextLine();
                    //Si posa si guardem i cridem al metode per sorit 
                    if (surt.equalsIgnoreCase("SI")) { 
                        gestor.desarTasques(Fitxer);
                        System.out.println(MSG_14);
                        gestor.sortir();   
                    }
                }
                case 5 -> {
                    //guardem i cridem al metode per sorit 
                    gestor.desarTasques(Fitxer);
                    System.out.println(MSG_14);
                    gestor.sortir();
                }
                //Si no posa ninguna de les 5 opcions li avisem que ho torni a intentar
                default -> System.out.println("Opcio no valida. Torna-ho a intentar.");
            }
        }
    }
}
