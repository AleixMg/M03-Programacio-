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

// Fem el main per gestionar els llibres amb el seu menu
public class Llibres {
    private static final String MSG_1 = "Tria una de les diferents opcions:";
    private static final String MSG_2 = "1.Registrar un llibre nou";
    private static final String MSG_3 = "2.Eliminar un llibre";
    private static final String MSG_4 = "3.Buscar un llibre per títol";
    private static final String MSG_5 = "4.Mostrar tots els llibres";
    private static final String MSG_6 = "5.Sortir del programa";
    private static final String MSG_7 = "Selecciona l'opció que vulguis:";
    private static final String MSG_8 = "Gràcies per utilitzar el programa, tingui un bon dia :)";
    private static final String MSG_9 = "Selecciona primer un Gènere (1. Novela, 2. Ciència-Ficció, 3. Poesia): ";
    private static final String MSG_10 = "Error en dades posi un número no una lletra ni un altre carcater"; 
    private static int opcions;

    public static void main(String[] args) {
        LlistaLlibres<Novela> llistaNoveles = new LlistaLlibres<>();
        LlistaLlibres<CienciaFiccio> llistaCienciaFiccio = new LlistaLlibres<>();
        LlistaLlibres<Poesia> llistaPoesia = new LlistaLlibres<>();

        Scanner sc = new Scanner(System.in);
        // la variable booleana correcte es per validar que s'hi introdueixin números
        boolean correcte;
        //Declarem també la variable opcio per a que després amb el switch case pugui escollir l'usuari l'opcio que vulgui.
        int opcio = 0;
        
        //Fem un bucle amb un do while per a que sempre mostri el menu menys quan es pren l'opcio 5
        do {
            System.out.println(MSG_1);
            System.out.println(MSG_2);
            System.out.println(MSG_3);
            System.out.println(MSG_4);
            System.out.println(MSG_5);
            System.out.println(MSG_6);
            
            
            //Fem un do while de forma que si l'usuari no posa un número i posa qualsevol altre carracter el programa no finalitzara fins que posi un, despres el swicth confirmara si es una acció valida  o no
            do{
                System.out.println(MSG_7);    
                correcte=sc.hasNextInt();
                if(correcte){
                    opcio = sc.nextInt();
                }else{
                    sc.next();
                    System.out.println(MSG_10);
                }
            }while(!correcte);
            sc.nextLine(); 
            
            //Utilitzem un siwtch case de forma que crudarem un metode depenent de l'opcio escollida
            switch (opcio) {
                case 1 -> {
                    System.out.print(MSG_9);
                    int genere = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Títol: ");
                    String titol = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Any: ");
                    int any = sc.nextInt();
                    sc.nextLine();
                    //Farem un altre swicth case dins per escollir el genere del llibre 
                    switch (genere) {
                        case 1 -> llistaNoveles.afegirLlibre(new Novela(titol, autor, any));
                        case 2 -> llistaCienciaFiccio.afegirLlibre(new CienciaFiccio(titol, autor, any));
                        case 3 -> llistaPoesia.afegirLlibre(new Poesia(titol, autor, any));
                        default -> System.out.println("Gènere no vàlid.");
                    }
                }
                case 2 -> {
                    System.out.print(MSG_9);
                    int genere = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Títol del llibre a eliminar: ");
                    String titol = sc.nextLine();
                    //Farem un altre swicth case dins per escollir el genere del llibre
                    switch (genere) {
                        case 1 -> llistaNoveles.eliminarLlibre(titol);
                        case 2 -> llistaCienciaFiccio.eliminarLlibre(titol);
                        case 3 -> llistaPoesia.eliminarLlibre(titol);
                        default -> System.out.println("Gènere no vàlid.");
                    }
                }
                case 3 -> {
                    System.out.print(MSG_9);
                    int genere = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Títol del llibre a buscar: ");
                    String titol = sc.nextLine();
                    Llibre llibreBuscat = null;
                    //Farem un altre swicth case dins per escollir el genere del llibre
                    switch (genere) {
                        case 1 -> llibreBuscat = llistaNoveles.buscarLlibre(titol);
                        case 2 -> llibreBuscat = llistaCienciaFiccio.buscarLlibre(titol);
                        case 3 -> llibreBuscat = llistaPoesia.buscarLlibre(titol);
                        default -> System.out.println("Gènere no vàlid.");
                    }

                    if (llibreBuscat != null) {
                        System.out.println("Llibre trobat: " + llibreBuscat);
                    } else {
                        System.out.println("Llibre no trobat.");
                    }
                }
                case 4 -> {
                    System.out.println("Llibres de Novela:");
                    llistaNoveles.mostrarLlibres();
                    System.out.println("Llibres de Ciència-Ficció:");
                    llistaCienciaFiccio.mostrarLlibres();
                    System.out.println("Llibres de Poesia:");
                    llistaPoesia.mostrarLlibres();
                }
                case 5 -> {
                    System.out.println(MSG_8);
                    opcions = 5;
                }
                default -> System.out.println("Opció no vàlida.");
            }

        } while (opcions != 5);
    }
}

