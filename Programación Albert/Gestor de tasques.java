package taskmanagement;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

class Tasca {
	// Anem a declarar cada variable del personatge.
	//<editor-fold defaultstate="collapsed" desc="Atributs">
	private static int cont = 0;
	private int id;
	private String descripcio;
	private boolean tasca_completada;
	private String prioritat;
	//</editor-fold>
	
	//Fem un constructor de la classe i inicialitzem les varibles d'instacia.
  	//<editor-fold defaultstate="collapsed" desc="Constructor Tasca">
	public Tasca(String descripcio, String prioritat) {
	//al contador li fiquem un autoincrement per a que autoincrementi la id de forma sola
    	this.id = ++cont;
    	this.descripcio = descripcio;
    	this.tasca_completada = false;
    	this.prioritat = prioritat;
	}
	//</editor-fold>

 	//Farem uns metodes d'accés a les varibles de la tasca amb els getters. 
	//<editor-fold defaultstate="collapsed" desc="Getters">
	public void marcarTascaCompletada() {
    	this.tasca_completada = true;
	}

	public int getID() {
    	return this.id;
	}

	public String getDescripcio() {
    	return this.descripcio;
	}

	public boolean estaCompletada() {
    	return this.tasca_completada;
	}

	public String getPrioritat() {
    	return this.prioritat;
	}

	//Fem un toString per convertir la informació en una cadena de text, ho seprearem amb tabulacions i dos |.
	@Override
	public String toString() {
    	String estat_tasca = tasca_completada ? "Completada" : "Pendent";
    	return "ID: " + id + "\t||Descripcio: " + descripcio + "\t||Prioritat: " + prioritat + "\t||Estat: " + estat_tasca;
	}
	//</editor-fold>
}

//Declarem la nova clase per gestionar les tasques
class GestorTasques {
	
	private static final String MSG_1 = "baixa";
	private static final String MSG_2 = "mitjana";
	private static final String MSG_3 = "alta";
	private HashMap<String, ArrayList<Tasca>> llistaPrioritat;
	private HashMap<Integer, Tasca> tasques;
	private Scanner scanner;

	public GestorTasques() {
    		llistaPrioritat = new HashMap<>();
    		llistaPrioritat.put(MSG_1, new ArrayList<>());
    		llistaPrioritat.put(MSG_2, new ArrayList<>());
    		llistaPrioritat.put(MSG_3, new ArrayList<>());
    		tasques = new HashMap<>();
    		scanner = new Scanner(System.in);
	}
	
	//Metode per afegir la tasca a partir de la ID que digui el usuari que vulgui modificar 
	public void afegirTasca(String descripcio, String prioritat) {
    		Tasca tasca = new Tasca(descripcio, prioritat);
    		llistaPrioritat.get(prioritat).add(tasca);
    		tasques.put(tasca.getID(), tasca);
	}

	//Metode per marcar la tasca a partir de la ID que digui el usuari que vulgui modificar
	public void marcarTascaCompletada(int idTasca) {
    		Tasca tasca = tasques.get(idTasca);
		if (tasca != null) {
      			tasca.marcarTascaCompletada();
    		}	
	}

	//Metode per esborrar la tasca a partir de la ID que digui el usuari que vulgui modificar
	public void esborrarTasca(int idTasca) {
    		Tasca tasca = tasques.remove(idTasca);
    		if (tasca != null) {
        		String prioritat = tasca.getPrioritat();
        		llistaPrioritat.get(prioritat).remove(tasca);
    		}
	}
	//Metode per afegir la tasca 
	public void mostrarTotesLesTasques() {
    	System.out.println("Totes les tasques:");
    		for (Tasca tasca : tasques.values()) {
        		System.out.println(tasca);
    		}
	}
	
	//Metode per afegir la tasca per ordre de prioritat
	public void mostrarTasquesPerPrioritat(String prioritat) {
    	System.out.println("Tasques de prioritat " + prioritat + ":");
    		for (Tasca tasca : llistaPrioritat.get(prioritat)) {
        		System.out.println(tasca);
    		}
	}
	
	//metode per sortir del programa 
	public void sortir() {
    		scanner.close();
    		System.exit(0);
	}
}
//Posem per ultim el main(el meu cas TaskManagement) amb els misatges del menu
public class TaskManagement {

	//Declarem aquesta variable per sortit del while
	private static String surt;
	private static final String MSG_1 = "********GESTOR DE TASQUES********";
	private static final String MSG_2 = "1.Afegir una nova tasca";
	private static final String MSG_3 = "2.Tasca com a completada";
	private static final String MSG_4 = "3.Borra una tasca";
	private static final String MSG_5 = "4.Mostra les tasques";
	private static final String MSG_6 = "5.Mostra les tasques per prioritat";
	private static final String MSG_7 = "6.Surt del programa";
	private static final String MSG_8 = "Selecciona una opcio: ";
	private static final String MSG_12 = "Error en dades posi un número no una lletra ni un altre carcater";
	private static final String MSG_13 = "Vols soritr del programa? (Introdueix SI o NO): ";
	private static final String MSG_14 = "Sortint del programa i guardant arxiu...Gracies per utilitzar el nostre gestor de tasques :) ";
    
	public static void main(String[] args) {
	GestorTasques gestor = new GestorTasques();
    	Scanner sc = new Scanner(System.in);
    	// la variable booleana correcte es per validar que s'hi introdueixin números
    	boolean correcte;
    	//Declarem també la variable opcio per a que després amb el switch case pugui escollir l'usuari l'opcio que vulgui.
    	int opcio = 0;



    	//amb un while (true) fem que sempre entrem al bucle del while i l'unica forma de sortir del programa sigui amb l'opció 5.
    	while (true) {
        	System.out.println(MSG_1);
        	System.out.println(MSG_2);
        	System.out.println(MSG_3);
        	System.out.println(MSG_4);
        	System.out.println(MSG_5);
        	System.out.println(MSG_6);
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
                	System.out.print("Descripcio de la tasca: ");
                	String descripcio = sc.nextLine();
                	System.out.print("Prioritat: baixa/mitjana/alta: ");
                	String prioritat = sc.nextLine().toLowerCase();
                	gestor.afegirTasca(descripcio, prioritat);
                	//Li preguntem al usuari si vol tancar el programa o continuar
                	System.out.print(MSG_13);
                	surt = sc.nextLine();
                	//Si posa si guardem i cridem al metode per sorit
                	if (surt.equalsIgnoreCase("SI")) {
                    	System.out.println(MSG_14);
                    	gestor.sortir();   
                	}
            	}
            	case 2 ->{
                	System.out.print("Numero de la tasca per marcar com completada: ");
                	int idTasca = sc.nextInt();
                	gestor.marcarTascaCompletada(idTasca);
                	//Li preguntem al usuari si vol tancar el programa o continuar
                	System.out.print(MSG_13);
                	surt = sc.nextLine();
                	//Si posa si guardem i cridem al metode per sorit
                	if (surt.equalsIgnoreCase("SI")) {
                    	System.out.println(MSG_14);
                    	gestor.sortir();   
                	}
            	}
            	case 3 ->{
                	System.out.print("Numero de la tasca per esborrar: ");
                	int idTasca = sc.nextInt();
                	gestor.esborrarTasca(idTasca);
                	//Li preguntem al usuari si vol tancar el programa o continuar
                	System.out.print(MSG_13);
                	surt = sc.nextLine();
                	//Si posa si guardem i cridem al metode per sorit
                	if (surt.equalsIgnoreCase("SI")) {
                    	System.out.println(MSG_14);
                    	gestor.sortir();   
                	}
            	}
            	case 4 ->{
                	//Cridem al metode per visualitzar les tasques
                	gestor.mostrarTotesLesTasques();
                	//Li preguntem al usuari si vol tancar el programa o continuar
                	System.out.print(MSG_13);
                	surt = sc.nextLine();
                	//Si posa si guardem i cridem al metode per sorit
                	if (surt.equalsIgnoreCase("SI")) {
                    	System.out.println(MSG_14);
                    	gestor.sortir();   
                	}
            	}
            	case 5 -> {
                	System.out.print("Prioritat a mostrar: baixa/mitjana/alta: ");
                	String prioritat = sc.nextLine().toLowerCase();
                	gestor.mostrarTasquesPerPrioritat(prioritat);
            	}
            	case 6 -> gestor.sortir();
            	//Si no posa ninguna de les 5 opcions li avisem que ho torni a intentar
            	default -> System.out.println("Opcio no valida. Torna-ho a intentar.");
        	}
    	}
	}
}


